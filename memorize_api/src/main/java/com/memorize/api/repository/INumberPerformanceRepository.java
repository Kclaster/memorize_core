package com.memorize.api.repository;

import com.memorize.model.number.NumberPerformanceDto;

import java.util.List;
import java.util.UUID;

public interface INumberPerformanceRepository {
    List<NumberPerformanceDto> getNumberPerformance(UUID numberId);
}
