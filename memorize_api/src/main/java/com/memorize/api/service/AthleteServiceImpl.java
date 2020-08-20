package com.memorize.api.service;

import com.memorize.api.repository.IAthleteRepository;
import com.memorize.model.athlete.AthleteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthleteServiceImpl implements IAthleteService {
    private final IAthleteRepository iAthleteRepository;

    @Autowired
    public AthleteServiceImpl(IAthleteRepository iAthleteRepository) {
        this.iAthleteRepository = iAthleteRepository;
    }

    @Override
    public AthleteDto getAthleteByUsername(String username) throws Exception {
        return iAthleteRepository.getAthleteByUsername(username);
    };
}
