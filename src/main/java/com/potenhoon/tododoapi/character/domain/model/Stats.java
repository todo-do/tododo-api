package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
