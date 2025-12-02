package com.potenhoon.tododoapi.character.application.service;

import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;

public interface CharacterService {

    CharacterResponse createCharacter(CharacterCreateRequest request);

    CharacterResponse getCharacterById(Long id);
}
