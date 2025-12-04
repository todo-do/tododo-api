package com.potenhoon.tododoapi.challenge.application.mission.dto;

import java.time.LocalDateTime;

public record RequestMissionCommand(
        Long userId,            // 작성자의 ID, Notnull
        Long questId,           // 미션의 퀘스트 ID, Notnull
        String title,           // 미션의 내용, Notnull
        LocalDateTime expiredAt // 미션의 만료일, Nullable
) {

}
