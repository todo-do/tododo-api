package com.potenhoon.tododoapi.character.infra.jpa;

import com.potenhoon.tododoapi.character.domain.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacterJpaRepository extends JpaRepository<Character, UUID> {
}
