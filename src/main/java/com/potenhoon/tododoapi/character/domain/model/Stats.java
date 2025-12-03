package com.potenhoon.tododoapi.character.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @Builder.Default
    @Column(name = "stat", nullable = false)
    private int stat = 0;

    void assignTo(Character character) {
        this.character = Objects.requireNonNull(character, "character must not be null");
    }

    public static Stats createStat(int stat) {
        return Stats.builder()
                .stat(stat)
                .build();
    }

    public int getStat() {
        return stat;
    }
}
