package com.potenhoon.tododoapi.character.domain.repository;

import com.potenhoon.tododoapi.character.domain.model.Character;

import java.util.Optional;
import java.util.UUID;


public interface CharacterRepository {
    Character save(Character character);
    Optional<Character> findById(UUID id);
}
