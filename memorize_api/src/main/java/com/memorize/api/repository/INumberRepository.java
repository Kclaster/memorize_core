package com.memorize.api.repository;

import com.memorize.model.number.NumberDto;
import com.memorize.model.number.NumberPerformancePostRequest;

import java.sql.Timestamp;
import java.util.UUID;

public interface INumberRepository {
    NumberDto getNumberData(UUID athleteId) throws Exception;
    void updateNumberData(UUID numberId, Timestamp now, NumberPerformancePostRequest numberPerformancePostRequest);
}
