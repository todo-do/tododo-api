package com.potenhoon.tododoapi.team.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(
        name = "team_manager_assignments",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_team_position", columnNames = {"team_id", "position"})
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TeamManagerAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(nullable = false)
    private Long managerUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private TeamPosition position = TeamPosition.MANAGER;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public TeamManagerAssignment(Team team, Long managerUserId, TeamPosition position) {
        this.team = team;
        this.managerUserId = managerUserId;
        this.position = position;
    }

    public static TeamManagerAssignment create(Team team, Long userId, TeamPosition teamPosition) {
        return new TeamManagerAssignment(team, userId, teamPosition);
    }

    protected void delete(){
        this.deletedAt = LocalDateTime.now();
    }

}
