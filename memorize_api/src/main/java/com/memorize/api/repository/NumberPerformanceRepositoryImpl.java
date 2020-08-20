package com.memorize.api.repository;

import com.memorize.model.helpers.SqlHelper;
import com.memorize.model.number.NumberPerformanceDto;
import com.memorize.model.number.NumberPerformanceDtoMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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

}
