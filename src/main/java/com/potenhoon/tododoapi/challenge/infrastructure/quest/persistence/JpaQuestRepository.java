package com.potenhoon.tododoapi.challenge.infrastructure.quest.persistence;

import com.potenhoon.tododoapi.challenge.domain.quest.model.entity.Quest;
import com.potenhoon.tododoapi.challenge.domain.quest.repository.QuestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaQuestRepository extends JpaRepository<Quest,Long>, QuestRepository {
}
