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

    @Column(name = "stat_a", nullable = false)
    private int a;
    @Column(name = "stat_b", nullable = false)
    private int b;
    @Column(name = "stat_c", nullable = false)
    private int c;
    @Column(name = "stat_d", nullable = false)
    private int d;
    @Column(name = "stat_e", nullable = false)
    private int e;
    @Column(name = "stat_f", nullable = false)
    private int f;

    protected Stats() {
        // for JPA
    }

    private Stats(int a, int b, int c, int d, int e, int f) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public static Stats createStat(int a, int b, int c, int d, int e, int f) {
        return new Stats(a, b, c, d, e, f);
    }

    public static Stats zero() {
        return createStat(0, 0, 0, 0, 0, 0);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }
}
