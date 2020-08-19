package com.memorize.model.Athlete;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AthleteDtoMapper implements RowMapper<AthleteDto> {
    public AthleteDto mapRow(ResultSet rs, int i) throws SQLException {
        AthleteDto athleteDto = new AthleteDto();
        athleteDto.setId(UUID.fromString(rs.getString("id")));

        return athleteDto;
    }
}
