package com.potenhoon.tododoapi.character.presentation.dto;

import java.util.UUID;

public record CharacterCreateRequest(
        String name,
        StatsRequest stats,
        UUID userId
) {
}
