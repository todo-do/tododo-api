package com.potenhoon.tododoapi.character.presentation.dto;

public record StatsResponse(int stat) {
    public static StatsResponse of(int stat) {
        return new StatsResponse(stat);
    }
}
