package com.potenhoon.tododoapi.challenge.application.mission.service;

import com.potenhoon.tododoapi.challenge.application.mission.dto.MissionResponse;
import com.potenhoon.tododoapi.challenge.application.mission.dto.RequestMissionCommand;
import com.potenhoon.tododoapi.challenge.domain.mission.model.entity.Mission;
import com.potenhoon.tododoapi.challenge.infrastructure.mission.JpaMissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class MissionService {

    private final JpaMissionRepository missionRepository;

    public MissionService(JpaMissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public MissionResponse create(RequestMissionCommand command) {
        // DTO 검사
        Objects.requireNonNull(command, "request must not be null");

        if (command.questId() == null) {
            //TODO 예외 처리 수정
            throw new IllegalArgumentException("ID must not be null");
        }
        if (command.userId() == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        if (command.title() == null || command.title().isBlank()) {
            throw new IllegalArgumentException("Title must not be null");
        }

        // 새로운 미션 생성
        Mission newMission = Mission.create(
                command.userId(),
                command.questId(),
                command.title(),
                command.expiredAt());

        // 미션 저장
        missionRepository.save(newMission);

        return MissionResponse.from(newMission);
    }
}
