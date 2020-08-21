package com.memorize.api.service;

import com.memorize.api.repository.INumberPerformanceRepository;
import com.memorize.api.repository.INumberRepository;
import com.memorize.model.number.NumberDto;
import com.memorize.model.number.NumberPerformancePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public void createNumberPerformance(UUID athleteId, UUID numberId, NumberPerformancePostRequest numberPerformancePostRequest) throws Exception {
        var now = new Timestamp(System.currentTimeMillis());
        iNumberPerformanceRepository.createNumberPerformance(numberId, now, numberPerformancePostRequest);

        // If new score beats best score, update the best score data.
        var numberDto = iNumberRepository.getNumberData(athleteId);
        if (numberPerformancePostRequest.getAttemptScore() > numberDto.getBestScore()) {
            iNumberRepository.updateNumberData(numberId, now, numberPerformancePostRequest);
        }
    }
}
