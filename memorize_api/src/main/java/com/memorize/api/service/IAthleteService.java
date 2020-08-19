package com.memorize.api.service;

import com.memorize.model.Athlete.AthleteDto;

public interface IAthleteService {
    AthleteDto getAthleteByUsername(String username) throws Exception;
}
