package com.potenhoon.tododoapi.character.application.service.impl;

import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;
import com.potenhoon.tododoapi.character.domain.repository.CharacterRepository;
import com.potenhoon.tododoapi.character.application.service.CharacterService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Character create(String name, Stats stats) {
        Character character = Character.create(name, stats);
        return repository.save(character);
    }

    @Override
    public Character get(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Character not found: " + id));
    }
}
