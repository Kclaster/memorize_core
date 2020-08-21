package com.memorize.api.repository;

import com.memorize.model.helpers.SqlHelper;
import com.memorize.model.number.NumberPerformanceDto;
import com.memorize.model.number.NumberPerformanceDtoMapper;
import com.memorize.model.number.NumberPerformancePostRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class NumberPerformanceRepositoryImpl implements INumberPerformanceRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NumberPerformanceRepositoryImpl(
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<NumberPerformanceDto> getNumberPerformance(UUID numberId) {
        Map<String, Object> params = Map.of(
                "numberId", numberId
        );

        String sql = SqlHelper.sql("select-number-performance-data");
        return namedParameterJdbcTemplate.query(
                sql,
                params,
                new NumberPerformanceDtoMapper()
        );
    }

    @Override
    public void createNumberPerformance(UUID numberId, Timestamp now, NumberPerformancePostRequest numberPerformancePostRequest) {
        String sql = SqlHelper.sql("insert-number-performance");

        var params = new HashMap<String, Object>();
        params.put("id", UUID.randomUUID());
        params.put("attemptDate", now);
        params.put("attemptScore", numberPerformancePostRequest.getAttemptScore());
        params.put("numberId", numberId);

        namedParameterJdbcTemplate.update(sql, params);

    }

}
