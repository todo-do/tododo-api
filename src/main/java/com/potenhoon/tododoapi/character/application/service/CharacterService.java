package com.potenhoon.tododoapi.character.application.service;

import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;

import java.util.UUID;

public interface CharacterService {

    CharacterResponse create(CharacterCreateRequest request);

    CharacterResponse get(UUID id);
}
