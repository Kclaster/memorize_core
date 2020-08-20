package com.memorize.model.number;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class NumberDtoMapper implements RowMapper<NumberDto> {
    public NumberDto mapRow(ResultSet rs, int i) throws SQLException {
        Timestamp bestScoreDate = rs.getTimestamp("bestScoreDate");

        NumberDto numberDto = new NumberDto();
        numberDto.setBestScore(rs.getInt("bestSCore"));
        numberDto.setBestScoreDate(bestScoreDate != null ? bestScoreDate.toInstant() : null);
        numberDto.setId(UUID.fromString(rs.getString("id")));

        return numberDto;
    }
}
