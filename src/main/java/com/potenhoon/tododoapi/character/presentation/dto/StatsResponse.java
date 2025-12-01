package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Stats;

public record StatsResponse(int a, int b, int c, int d, int e, int f) {
    public static StatsResponse from(Stats stats) {
        return new StatsResponse(
                stats.getA(),
                stats.getB(),
                stats.getC(),
                stats.getD(),
                stats.getE(),
                stats.getF()
        );
    }
}
