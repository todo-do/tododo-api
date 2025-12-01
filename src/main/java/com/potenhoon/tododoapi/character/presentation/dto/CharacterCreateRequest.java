package com.potenhoon.tododoapi.character.presentation.dto;

import com.potenhoon.tododoapi.character.domain.model.Stats;

import java.util.UUID;

public record CharacterCreateRequest(
        String name,
        StatsRequest stats,
        UUID userId
) {

}
