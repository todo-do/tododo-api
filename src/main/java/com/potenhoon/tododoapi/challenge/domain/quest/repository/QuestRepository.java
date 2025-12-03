package com.potenhoon.tododoapi.challenge.domain.quest.repository;

import com.potenhoon.tododoapi.challenge.domain.quest.model.entity.Quest;

import java.util.Optional;

public interface QuestRepository {

    Quest save(Quest quest);

    Optional<Quest> findById(Long id);


}
