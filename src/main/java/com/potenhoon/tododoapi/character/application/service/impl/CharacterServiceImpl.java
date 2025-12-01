package com.potenhoon.tododoapi.character.application.service.impl;

import com.potenhoon.tododoapi.character.application.service.CharacterService;
import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;
import com.potenhoon.tododoapi.character.domain.repository.CharacterRepository;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public CharacterResponse create(CharacterCreateRequest request) {
        Stats stats = request.stats() == null ? Stats.zero() : request.stats().toStats();
        Character character = Character.create(request.name(), stats);
        var saved = repository.save(character);
        return CharacterResponse.from(saved);
    }

    @Override
    public CharacterResponse get(UUID id) {
        var found = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found: " + id));
        return CharacterResponse.from(found);
    }
}
