package com.potenhoon.tododoapi.challenge.domain.mission.model.entity;

public enum MissionStatus {
    ACTIVE,     // 미션 생성 시 default
    COMPLETED,  // 미션 완료 시
    EXPIRED,    // 미션 만료 시
    DELETED     // 미션 삭제 시
}
