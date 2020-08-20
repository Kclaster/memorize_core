package com.memorize.model.number;

import java.time.Instant;
import java.util.UUID;

public class NumberPerformanceDto {
    private UUID id;
    private Instant attemptDate;
    private int attemptScore;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(Instant attemptDate) {
        this.attemptDate = attemptDate;
    }

    public int getAttemptScore() {
        return attemptScore;
    }

    public void setAttemptScore(int attemptScore) {
        this.attemptScore = attemptScore;
    }
}
