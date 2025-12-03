package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID userId;

    @OneToOne(mappedBy = "character", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    private Stats stats;

    protected Character() {
        // for JPA
    }

    private Character(String name, UUID userId, Stats stats) {
        this.name = Objects.requireNonNull(name, "name must not be null"); // 닉네임 정책 고민
        this.userId = Objects.requireNonNull(userId, "userId must not be null");
        setStats(stats);
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("name must not be blank");
        }
    }

    public static Character create(String name, UUID userId) {
        return create(name, userId, Stats.builder().build());
    }

    public static Character create(String name, UUID userId, Stats stats) {
        return new Character(name, userId, Objects.requireNonNull(stats, "stats must not be null"));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getUserId() {
        return userId;
    }

    public Stats getStats() {
        return stats;
    }

    private void setStats(Stats stats) {
        this.stats = Objects.requireNonNull(stats, "stats must not be null");
        this.stats.assignTo(this);
    }
}
