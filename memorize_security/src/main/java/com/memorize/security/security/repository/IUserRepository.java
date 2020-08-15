package com.memorize.security.security.repository;

import com.memorize.model.AuthUserRequest;
import com.memorize.model.User;

import java.util.Optional;


public interface IUserRepository {
    Optional<User> selectUserByUsername(String username);

    void saveAuthUser(AuthUserRequest authUserRequest) throws Exception;
}
