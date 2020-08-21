package com.memorize.security.security.repository;

import com.memorize.model.auth.AuthUserRequest;
import com.memorize.model.auth.AuthUser;

import java.util.Optional;


public interface IUserRepository {
    Optional<AuthUser> selectUserByUsername(String username);

    void saveAuthUser(AuthUserRequest authUserRequest) throws Exception;
}
