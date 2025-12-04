package com.potenhoon.tododoapi.challenge.domain.mission.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

//    TODO Quest 연관관계 정의 및 매핑
    @Column(name = "quest_id", nullable = false, columnDefinition = "bigint comment '퀘스트ID(약결합 키)'")
    private Long questId;

//    TODO User 연관관계 정의 및 매핑, VO로 작업 예정
//    @Embedded
    @Column(name = "user_id", nullable = false, columnDefinition = "bigint comment '유저ID(약결합 키)'")
    private Long userId;

//    미션의 내용 = 미션의 제목
    @Column(name = "title")
    private String title;

//    MissionStatus = ACTIVE, COMPLETED, EXPIRED, DELETED
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MissionStatus status;

//    미션의 생성과 동시에 확정
//    DATETIME(0) : 소수점 이하 초 단위 버림
    @Column(name = "created_at", columnDefinition = "DATETIME(0)", nullable = false, updatable = false)
    private LocalDateTime createdAt;

//    만료일이 없는 단순 기록용 할 일이 있을 수 있다.
    @Column(name = "expired_at", columnDefinition = "DATETIME(0)", nullable = true)
    private LocalDateTime expiredAt;

    protected Mission() {}

    private Mission(Long userId, Long questId, String title, LocalDateTime expiredAt) {
        this.userId = userId;
        this.questId = questId;
        this.title = title;
        this.expiredAt = expiredAt;

        // Mission 생성 시 default 값
        this.status = MissionStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    // Mission 생성
    public static Mission create(Long userId, Long questId, String title, LocalDateTime expiredAt) {
        return new Mission(userId, questId, title, expiredAt);
    }

    // Getter
    public Long getId() {
        return id;
    }

    public Long getQuestId() {
        return questId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }
}
