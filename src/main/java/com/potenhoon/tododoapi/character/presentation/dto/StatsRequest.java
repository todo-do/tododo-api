package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Stats;

public record StatsRequest(int a, int b, int c, int d, int e, int f) {
    public Stats toStats() {
        return Stats.createStat(a, b, c, d, e, f);
    }
}
