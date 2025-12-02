package com.potenhoon.tododoapi.character.domain.repository;

import com.potenhoon.tododoapi.character.domain.model.Character;

import java.util.Optional;

public interface CharacterRepository {
    Character save(Character character);
    Optional<Character> findById(Long id);
}
