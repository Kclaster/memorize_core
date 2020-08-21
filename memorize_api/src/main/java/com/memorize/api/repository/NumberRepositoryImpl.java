package com.memorize.api.repository;

import com.memorize.model.helpers.SqlHelper;
import com.memorize.model.number.NumberDto;
import com.memorize.model.number.NumberDtoMapper;
import com.memorize.model.number.NumberPerformancePostRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class NumberRepositoryImpl implements INumberRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NumberRepositoryImpl(
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public NumberDto getNumberData(UUID athleteId) throws Exception {
        Map<String, Object> params = Map.of(
                "athleteId", athleteId
        );

        String sql = SqlHelper.sql("select-number-data");
        var numberDtoList = namedParameterJdbcTemplate.query(
                sql,
                params,
                new NumberDtoMapper()
        );


        if (numberDtoList.size() != 1) {
            throw new Exception("Cannot find number data associated with " + athleteId);
        }

        return numberDtoList.get(0);

    }

    @Override
    public void updateNumberData(UUID numberId, Timestamp now, NumberPerformancePostRequest numberPerformancePostRequest) {
        String sql = SqlHelper.sql("update-number-data");

        var params = new HashMap<String, Object>();
        params.put("bestScoreDate", now);
        params.put("bestScore", numberPerformancePostRequest.getAttemptScore());
        params.put("numberId", numberId);

        namedParameterJdbcTemplate.update(sql, params);

    }
}
