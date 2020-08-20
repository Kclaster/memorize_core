package com.memorize.api.repository;

import com.memorize.model.number.NumberDto;

import java.util.UUID;

public interface INumberRepository {
    NumberDto getNumberData(UUID athleteId) throws Exception;
}
