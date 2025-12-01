package com.potenhoon.tododoapi.character.application.service;

import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;

import java.util.UUID;

public interface CharacterService {

    Character create(String name, Stats stats);

    Character get(UUID id);
}
