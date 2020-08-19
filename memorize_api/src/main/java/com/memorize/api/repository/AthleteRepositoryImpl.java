package com.memorize.api.repository;

import com.memorize.model.Athlete.AthleteDto;
import com.memorize.model.Athlete.AthleteDtoMapper;
import com.memorize.model.helpers.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AthleteRepositoryImpl implements IAthleteRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AthleteRepositoryImpl(
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public AthleteDto getAthleteByUsername(String username) throws Exception {
        Map<String, Object> params = Map.of(
                "username", username
        );

        String sql = SqlHelper.sql("select-athlete-from-auth-username");
        var athleteDtoList = namedParameterJdbcTemplate.query(
                sql,
                params,
                new AthleteDtoMapper()
        );

        if (athleteDtoList.size() != 1) {
            throw new Exception("Cannot find user associated with " + username);
        }

        return athleteDtoList.get(0);
    }
}
