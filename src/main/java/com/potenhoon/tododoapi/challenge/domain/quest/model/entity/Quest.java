package com.potenhoon.tododoapi.challenge.domain.quest.model.entity;

import com.potenhoon.tododoapi.challenge.domain.quest.model.vo.QuestStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "quests")
@SQLDelete(sql = "UPDATE quests SET del_flag = true WHERE id = ?")
public class Quest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_id", updatable = false, nullable = false)
    private long id;

    // 논리적 삭제를 위한 del flag
    @Column(name = "del_flag", nullable = false)
    private boolean delFlag = false; // 기본 값은 false로

    // 팀 아이디
    @Column(name = "team_id", nullable = false)
    private Long teamId;

    // 퀘스트 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 퀘스트 설명
    @Column(name = "description")
    private String description;

    // 퀘스트의 상태 값
    @Enumerated(EnumType.STRING) // String으로 설정한 이유 : Ordinal로 설정하면 추후 상태 값이 늘어나거나 변경되면 꼬일 수 있음.
    @Column(name = "status", nullable = false)
    private QuestStatus status;

    // 퀘스트 생성일 (시스템)
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // 퀘스트 시작일 (비즈니스적)
    @Column(name = "started_at")
    private LocalDateTime startedAt;

    // 퀘스트 만료일 (비즈니스적)
    @Column(name = "expiration_at")
    private LocalDateTime expirationAt;

    // 퀘스트 업데이트일 (시스템)
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // JPA를 위한 기본 생성자
    protected Quest() {}

    private Quest(Long teamId, String title, String description, LocalDateTime startedAt, LocalDateTime expirationAt) {
        this.title = Objects.requireNonNull(title, "title cannot be null");
        this.description = description;
        this.startedAt = startedAt;
        this.expirationAt = expirationAt;
        this.teamId = teamId;

        this.status = QuestStatus.IN_PROGRESS;
    }

    public static Quest createQuest(Long teamId, String title, String description, LocalDateTime startedAt, LocalDateTime expirationAt) {
        return new Quest(teamId, title, description, startedAt, expirationAt);
    }

    // Getter
    // TODO : 추후에 필요 없으면 제거해야 할 Getter
    public long getId() {
        return id;
    }
}
