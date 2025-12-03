package com.potenhoon.tododoapi.challenge.application.quest.service;

import com.potenhoon.tododoapi.challenge.application.quest.dto.QuestCreateCommand;
import com.potenhoon.tododoapi.challenge.domain.quest.model.entity.Quest;
import com.potenhoon.tododoapi.challenge.domain.quest.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestService {

    private QuestRepository questRepository;

    @Autowired
    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public Long register(QuestCreateCommand request) {

        // TODO : 여기서 정책 로직을 검증한다 ?
        // Quest는 팀장만 생성이 가능해야 한다.
        Quest newQuest = Quest.createQuest(request.teamId(), request.title(), request.description(), request.startedAt(), request.expirationAt());
        Quest saved = questRepository.save(newQuest);

        return saved.getId();
    }
}
