package com.potenhoon.tododoapi.character.application.service.impl;

import com.potenhoon.tododoapi.character.application.service.CharacterService;
import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;
import com.potenhoon.tododoapi.character.domain.repository.CharacterRepository;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;

    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public CharacterResponse createCharacter(CharacterCreateRequest request) {
        Stats stats = request.stats() == null ? Stats.zero() : request.stats().toStats();
        Character character = Character.create(request.name(), request.userId(), stats);
        Character charactersaved = repository.save(character);
        return CharacterResponse.from(charactersaved);
    }

    @Override
    public CharacterResponse getCharacterById(Long id) {
        Character foundcharacter = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Character not found: " + id));
        return CharacterResponse.from(foundcharacter);
    }
}
