package com.memorize.api.service;

import com.memorize.api.repository.INumberPerformanceRepository;
import com.memorize.api.repository.INumberRepository;
import com.memorize.model.number.NumberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NumberServiceImpl implements INumberService {
    private final INumberRepository iNumberRepository;
    private final INumberPerformanceRepository iNumberPerformanceRepository;

    @Autowired
    public NumberServiceImpl(
            INumberRepository iNumberRepository,
            INumberPerformanceRepository iNumberPerformanceRepository
    ) {
        this.iNumberRepository = iNumberRepository;
        this.iNumberPerformanceRepository = iNumberPerformanceRepository;
    }

    @Override
    public NumberDto getNumberData(UUID athleteId) throws Exception {
        var numberDto = iNumberRepository.getNumberData(athleteId);
        numberDto.setNumberPerformances(
                iNumberPerformanceRepository.getNumberPerformance(numberDto.getId()));

        return numberDto;
    }
}
