package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Stats stats;

    protected Character() {
        // for JPA
    }

    private Character(UUID id, String name, Stats stats) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null").trim();
        this.stats = Objects.requireNonNull(stats, "stats must not be null");
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("name must not be blank");
        }
    }

    public static Character create(String name) {
        return create(name, Stats.zero());
    }

    public static Character create(String name, Stats stats) {
        Stats resolved = stats == null ? Stats.zero() : stats;
        return new Character(UUID.randomUUID(), name, resolved);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Stats getStats() {
        return stats;
    }
}
