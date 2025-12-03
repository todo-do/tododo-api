package com.potenhoon.tododoapi.character.application.service.impl;

import com.potenhoon.tododoapi.character.application.service.CharacterService;
import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;
import com.potenhoon.tododoapi.character.domain.repository.CharacterRepository;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;
import com.potenhoon.tododoapi.character.presentation.dto.StatsResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public CharacterResponse createCharacter(CharacterCreateRequest request) {
        Character character = request.stats() == null
                ? Character.create(request.name(), request.userId())
                : Character.create(request.name(), request.userId(), request.stats().toStats());
        Character charactersaved = repository.save(character);
        return toResponse(charactersaved);
    }

    @Override
    public CharacterResponse getCharacterById(UUID userId) {
        Character foundcharacter = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Character not found: " + userId));
        return toResponse(foundcharacter);
    }

    private CharacterResponse toResponse(Character character) {
        return CharacterResponse.of(
                character.getId(),
                character.getUserId(),
                character.getName(),
                StatsResponse.of(character.getStats().getStat())
        );
    }
}
