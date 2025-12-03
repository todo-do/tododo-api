package com.potenhoon.tododoapi.challenge.application.quest.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record QuestCreateCommand(
    Long teamId,
    String title,
    String description,
    LocalDateTime startedAt,
    LocalDateTime expirationAt
) {
}
