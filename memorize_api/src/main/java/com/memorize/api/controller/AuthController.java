package com.memorize.api.controller;

import com.memorize.api.service.IAthleteService;
import com.memorize.model.AuthUserRequest;
import com.memorize.model.AuthenticationRequest;
import com.memorize.security.security.config.JwtConfig;
import com.memorize.security.security.service.IAuthUserService;
import com.memorize.security.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final IAuthUserService iAuthUserService;
    private final IAthleteService iAthleteService;
    private final JwtUtil jwtUtil;
    private final JwtConfig jwtConfig;

    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            IAuthUserService iAuthUserService,
            IAthleteService iAthleteService,
            JwtUtil jwtUtil,
            JwtConfig jwtConfig
    ) {
        this.authenticationManager = authenticationManager;
        this.iAuthUserService = iAuthUserService;
        this.iAthleteService = iAthleteService;
        this.jwtUtil = jwtUtil;
        this.jwtConfig = jwtConfig;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUserAccount(
            @Valid @RequestBody AuthUserRequest authUserRequest,
            Errors errors) throws NullPointerException {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        try {
            iAuthUserService.registerNewUserAccount(authUserRequest);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/authenticate")
    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        // Prove I am who I say I am
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        try {
            var athleteDto = iAthleteService.getAthleteByUsername(authenticationRequest.getUsername());
            var claims = new HashMap<String, Object>();
            claims.put("athleteId", athleteDto);

            final UserDetails userDetails = iAuthUserService
                    .loadUserByUsername(authenticationRequest.getUsername());

            // Add new instance of jwt token to custom header
            final String jwt = jwtUtil.generateToken(userDetails, claims);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix() + jwt);


            return new ResponseEntity<>(responseHeaders, HttpStatus.OK);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e);
        }

    }
}
