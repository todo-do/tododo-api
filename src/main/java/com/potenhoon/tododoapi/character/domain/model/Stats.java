package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Stats {

    @Column(name = "stat_a")
    private int a;
    @Column(name = "stat_b")
    private int b;
    @Column(name = "stat_c")
    private int c;
    @Column(name = "stat_d")
    private int d;
    @Column(name = "stat_e")
    private int e;
    @Column(name = "stat_f")
    private int f;

    protected Stats() {
        // for JPA
    }

    public Stats(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public static Stats getStats(Stats stats) {
        return new Stats(stats.a, stats.b, stats.c, stats.d, stats.e, stats.f);
    }

    public static Stats zero() {
        return new Stats(0, 0, 0, 0, 0, 0);
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
