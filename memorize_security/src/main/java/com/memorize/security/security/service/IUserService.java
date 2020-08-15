package com.memorize.security.security.service;

import com.memorize.model.AuthUserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    void registerNewUserAccount(AuthUserRequest authUserRequest) throws Exception;

    UserDetails loadUserByUsername(String username);
}
