package com.memorize.api.repository;

import com.memorize.model.number.NumberPerformanceDto;
import com.memorize.model.number.NumberPerformancePostRequest;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface INumberPerformanceRepository {
    List<NumberPerformanceDto> getNumberPerformance(UUID numberId);
    void createNumberPerformance(UUID numberId, Timestamp now, NumberPerformancePostRequest numberPerformancePostRequest);
}
