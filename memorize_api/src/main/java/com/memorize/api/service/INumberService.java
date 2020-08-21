package com.memorize.api.service;

import com.memorize.model.number.NumberDto;
import com.memorize.model.number.NumberPerformancePostRequest;

import java.util.UUID;

public interface INumberService {
    NumberDto getNumberData(UUID athleteId) throws Exception;
    void createNumberPerformance(UUID numberId, NumberPerformancePostRequest numberPerformancePostRequest);
}
