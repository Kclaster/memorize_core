package com.memorize.security.security.service;

import com.memorize.model.auth.AuthUserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAuthUserService extends UserDetailsService {
    void registerNewUserAccount(AuthUserRequest authUserRequest) throws Exception;

    UserDetails loadUserByUsername(String username);
}
