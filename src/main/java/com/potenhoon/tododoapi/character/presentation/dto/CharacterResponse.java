package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;

import java.util.UUID;

public record CharacterResponse(UUID id, String name, Stats stats) {
    public static CharacterResponse from(Character character) {
        return new CharacterResponse(character.getId(), character.getName(), character.getStats());
    }
}
