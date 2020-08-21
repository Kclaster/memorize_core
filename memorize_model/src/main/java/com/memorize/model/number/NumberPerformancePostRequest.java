package com.memorize.model.number;

import org.immutables.value.Value;

import javax.validation.constraints.NotNull;

@Value.Immutable
public class NumberPerformancePostRequest {
    @NotNull
    private Integer attemptScore;

    public Integer getAttemptScore() {
        return attemptScore;
    }

    public void setAttemptScore(Integer attemptScore) {
        this.attemptScore = attemptScore;
    }

}
