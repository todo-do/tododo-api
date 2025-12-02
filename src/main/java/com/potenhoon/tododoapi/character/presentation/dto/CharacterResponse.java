package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Character;

import java.util.UUID;

public record CharacterResponse(Long id, UUID userId, String name, StatsResponse stats) {
    public static CharacterResponse from(Character character) {
        return new CharacterResponse(
                character.getId(),
                character.getUserId(),
                character.getName(),
                StatsResponse.from(character.getStats())
        );
    }
}
