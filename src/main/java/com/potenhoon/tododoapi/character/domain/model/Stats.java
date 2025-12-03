package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @Column(name = "character_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "character_id")
    private Character character;

    @Column(name = "stat", nullable = false)
    private int stat;

    protected Stats() {
        // for JPA
    }

    private Stats(int stat) {
        this.stat = stat;
    }

    void assignTo(Character character) {
        this.character = Objects.requireNonNull(character, "character must not be null");
    }

    public static Stats createStat(int stat) {
        return new Stats(stat);
    }

    public static Stats zero() {
        return createStat(0);
    }

    public int getStat() {
        return stat;
    }
}
