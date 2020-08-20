package com.memorize.api.service;

import com.memorize.model.number.NumberDto;

import java.util.UUID;

public interface INumberService {
    NumberDto getNumberData(UUID athleteId) throws Exception;
}
