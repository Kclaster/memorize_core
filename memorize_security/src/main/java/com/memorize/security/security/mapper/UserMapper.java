package com.memorize.security.security.mapper;

import com.memorize.model.User;
import com.memorize.model.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int i) throws SQLException {
        Optional<UserRole> roleId = UserRole.valueOf(rs.getInt("roleId"));

        return new User(
                UUID.fromString(rs.getString("id")),
                rs.getString("username"),
                rs.getString("password"),
                roleId.map(UserRole::getGrantedAuthorities).orElse(null),
                rs.getBoolean("isExpired"),
                rs.getBoolean("isLocked"),
                rs.getBoolean("isCredentialsExpired"),
                rs.getBoolean("isEnabled"),
                rs.getInt("roleId"));
    }
}