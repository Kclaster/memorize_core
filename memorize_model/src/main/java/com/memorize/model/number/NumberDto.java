package com.memorize.model.number;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class NumberDto {
    private UUID id;
    private Instant bestScoreDate;
    private int bestScore;
    private List<NumberPerformanceDto> numberPerformances;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getBestScoreDate() {
        return bestScoreDate;
    }

    public void setBestScoreDate(Instant bestScoreDate) {
        this.bestScoreDate = bestScoreDate;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public List<NumberPerformanceDto> getNumberPerformances() {
        return numberPerformances;
    }

    public void setNumberPerformances(List<NumberPerformanceDto> numberPerformance) {
        this.numberPerformances = numberPerformance;
    }
}
