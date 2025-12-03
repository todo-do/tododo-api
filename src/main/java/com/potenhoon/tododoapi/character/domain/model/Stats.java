package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private Long id;

    @Column(name = "stat", nullable = false)
    private int stat;

    protected Stats() {
        // for JPA
    }

    private Stats(int stat) {
        this.stat = stat;
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
