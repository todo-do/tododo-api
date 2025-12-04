package com.potenhoon.tododoapi.challenge.application.mission.dto;

import com.potenhoon.tododoapi.challenge.domain.mission.model.entity.Mission;
import com.potenhoon.tododoapi.challenge.domain.mission.model.entity.MissionStatus;

import java.time.LocalDateTime;

// 생성된 미션 정보 조회 용
public record MissionResponse(
        Long userId,
        Long questId,
        String title,
        MissionStatus missionStatus,
        LocalDateTime createdAt,
        LocalDateTime expiredAt
) {
// Response 변환용
    public static MissionResponse from(Mission mission) {
        return new MissionResponse(
                mission.getUserId(),
                mission.getQuestId(),
                mission.getTitle(),
                mission.getStatus(),
                mission.getCreatedAt(),
                mission.getExpiredAt()
        );
    }
}
