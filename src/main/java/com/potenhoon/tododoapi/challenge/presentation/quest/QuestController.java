package com.potenhoon.tododoapi.challenge.presentation.quest;

import com.potenhoon.tododoapi.challenge.application.quest.dto.QuestCreateCommand;
import com.potenhoon.tododoapi.challenge.application.quest.service.QuestService;
import com.potenhoon.tododoapi.challenge.presentation.quest.dto.QuestCreateRequest;
import com.potenhoon.tododoapi.challenge.presentation.quest.dto.QuestCreateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quests")
public class QuestController {

    private final QuestService questService;

    @Autowired
    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    @PostMapping
    public ResponseEntity<QuestCreateResponse> createQuest(@Valid @RequestBody QuestCreateRequest request) {
        Long questId = questService.register(new QuestCreateCommand(request.teamId(), request.title(), request.description(), request.startedAt(), request.expirationAt()));

        QuestCreateResponse questCreateResponse = new QuestCreateResponse(questId);
        return ResponseEntity.ok(questCreateResponse);
    }
}
