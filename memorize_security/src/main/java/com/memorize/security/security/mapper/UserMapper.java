package com.memorize.security.security.mapper;

import com.memorize.model.auth.AuthUser;
import com.memorize.model.auth.AuthUserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class UserMapper implements RowMapper<AuthUser> {
    public AuthUser mapRow(ResultSet rs, int i) throws SQLException {
        Optional<AuthUserRole> roleId = AuthUserRole.valueOf(rs.getInt("roleId"));

        return new AuthUser(
                UUID.fromString(rs.getString("id")),
                rs.getString("username"),
                rs.getString("password"),
                roleId.map(AuthUserRole::getGrantedAuthorities).orElse(null),
                rs.getBoolean("isExpired"),
                rs.getBoolean("isLocked"),
                rs.getBoolean("isCredentialsExpired"),
                rs.getBoolean("isEnabled"),
                rs.getInt("roleId"));
    }
}