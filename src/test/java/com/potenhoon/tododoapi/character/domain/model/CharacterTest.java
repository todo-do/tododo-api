package com.potenhoon.tododoapi.character.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void createWithDefaultStats_setsZeroStat() {
        UUID userId = UUID.randomUUID();

        Character character = Character.create("hero", userId);

        assertEquals("hero", character.getName());
        assertEquals(userId, character.getUserId());
        assertEquals(0, character.getStats().getStat());
    }

    @Test
    void createWithCustomStats_usesProvidedStats() {
        UUID userId = UUID.randomUUID();
        Stats stats = Stats.createStat(5);

        Character character = Character.create("hero", userId, stats);

        assertEquals(5, character.getStats().getStat());
    }

    @Test
    void createWithBlankName_throwsIllegalArgumentException() {
        UUID userId = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> Character.create("   ", userId));
    }

    @Test
    void createWithNullName_throwsNullPointerException() {
        UUID userId = UUID.randomUUID();

        assertThrows(NullPointerException.class, () -> Character.create(null, userId));
    }

    @Test
    void createWithNullUserId_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Character.create("hero", null));
    }
}
