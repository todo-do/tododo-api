package com.potenhoon.tododoapi.character.presentation.dto;

import java.util.UUID;

public record CharacterResponse(Long id, UUID userId, String name, StatsResponse stats) {
    public static CharacterResponse of(Long id, UUID userId, String name, StatsResponse stats) {
        return new CharacterResponse(id, userId, name, stats);
    }
}
