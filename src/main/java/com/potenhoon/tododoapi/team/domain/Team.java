package com.potenhoon.tododoapi.team.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<TeamManagerAssignment> managerAssignments = new ArrayList<>();


    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updated_at;

    @Column(name = "deletedAt")
    private LocalDateTime deleted_at;

    public Team(String teamName) {
        this.name = teamName;
    }

    public Team create(Long userId, String teamName){
        assignLeader(userId);
        return new Team(teamName);
    }

    public void assignLeader(Long userId) {
        TeamManagerAssignment assignment =
                TeamManagerAssignment.create(this, userId, TeamPosition.LEADER);
    }


}
