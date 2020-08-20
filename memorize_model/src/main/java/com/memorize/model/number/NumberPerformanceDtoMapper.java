package com.memorize.model.number;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class NumberPerformanceDtoMapper implements RowMapper<NumberPerformanceDto> {
    public NumberPerformanceDto mapRow(ResultSet rs, int i) throws SQLException {
        var attemptDate = rs.getTimestamp("attemptDate");

        NumberPerformanceDto numberPerformanceDto = new NumberPerformanceDto();
        numberPerformanceDto.setAttemptScore(rs.getInt("attemptScore"));
        numberPerformanceDto.setAttemptDate(attemptDate != null ? attemptDate.toInstant() : null);
        numberPerformanceDto.setId(UUID.fromString(rs.getString("id")));

        return numberPerformanceDto;
    }
}
