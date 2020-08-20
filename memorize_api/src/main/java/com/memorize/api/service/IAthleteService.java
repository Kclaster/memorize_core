package com.memorize.api.service;

import com.memorize.model.athlete.AthleteDto;

public interface IAthleteService {
    AthleteDto getAthleteByUsername(String username) throws Exception;
}
