package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Stats;

public record StatsRequest(int stat) {
    public Stats toStats() {
        return Stats.createStat(0);
    }
}
