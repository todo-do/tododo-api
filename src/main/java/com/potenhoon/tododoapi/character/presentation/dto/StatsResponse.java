package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Stats;

public record StatsResponse(int stat) {
    public static StatsResponse from(Stats stats) {
        return new StatsResponse(
                stats.getStat());

    }
}
