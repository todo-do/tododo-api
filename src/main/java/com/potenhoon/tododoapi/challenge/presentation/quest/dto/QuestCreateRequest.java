package com.potenhoon.tododoapi.challenge.presentation.quest.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record QuestCreateRequest(
    @NotNull(message = "team_id is not null.")
    Long teamId,

    @NotNull(message = "title is not null.")
    String title,

    String description,
    LocalDateTime startedAt,
    LocalDateTime expirationAt
) {
}
