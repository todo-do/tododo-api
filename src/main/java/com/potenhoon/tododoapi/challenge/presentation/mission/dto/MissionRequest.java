package com.potenhoon.tododoapi.challenge.presentation.mission.dto;

import com.potenhoon.tododoapi.challenge.application.mission.dto.RequestMissionCommand;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

public record MissionRequest(
//      @Notnull, NotBlank 등 제약조건 추가 예정
        @NotNull
        Long userId,

        @NotNull
        Long questId,

        @NotNull
        String title,

        LocalDateTime expiredAt // nullable
) {

}
