package com.memorize.api.repository;

import com.memorize.model.Athlete.AthleteDto;

public interface IAthleteRepository {
    AthleteDto getAthleteByUsername(String username) throws Exception;
}
