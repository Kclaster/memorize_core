package com.memorize.security.security.repository;

import com.memorize.model.AuthUserRequest;
import com.memorize.model.User;
import com.memorize.model.helpers.SqlHelper;
import com.memorize.security.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserRepositoryImpl(@Qualifier("coreJdbcTemplate") JdbcTemplate jdbcTemplate,
                              NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        String sql = SqlHelper.sql("select-auth-user");
        try {
            List<User> authUserEntities = jdbcTemplate.query(
                    sql,
                    new UserMapper(),
                    username
            );

            if (authUserEntities.size() == 1) {
                return Optional.of(authUserEntities.get(0));
            }
            return Optional.empty();
        } catch (Exception e) {
            System.out.println(e);
        }

        return Optional.empty();
    }

    @Override
    public void saveAuthUser(AuthUserRequest authUserRequest) throws  Exception {
        String sql = SqlHelper.sql("insert-auth-user");
        UUID newAuthUserId = UUID.randomUUID();

        Map<String, Object> params = Map.of(
                "id", newAuthUserId,
                "username", authUserRequest.getUsername(),
                "password", authUserRequest.getPassword(),
                "authUserRoleId", authUserRequest.getRoleId()
        );

        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (Exception e) {
            throw e;
        }
    }

}
