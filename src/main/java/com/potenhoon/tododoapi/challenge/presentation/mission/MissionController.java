package com.potenhoon.tododoapi.challenge.presentation.mission;

import com.potenhoon.tododoapi.challenge.application.mission.dto.MissionResponse;
import com.potenhoon.tododoapi.challenge.application.mission.dto.RequestMissionCommand;
import com.potenhoon.tododoapi.challenge.application.mission.service.MissionService;
import com.potenhoon.tododoapi.challenge.presentation.mission.dto.MissionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

//  TODO Valid 추가
    @PostMapping
    public ResponseEntity<MissionResponse> save(@RequestBody MissionRequest request) {

        MissionResponse missionResponse = missionService.create(new RequestMissionCommand(
                request.userId(),
                request.questId(),
                request.title(),
                request.expiredAt()
        ));

        return ResponseEntity.status(HttpStatus.CREATED).body(missionResponse);
    }
}
