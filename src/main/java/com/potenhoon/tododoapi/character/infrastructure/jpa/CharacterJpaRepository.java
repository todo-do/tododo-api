package com.potenhoon.tododoapi.character.infrastructure.jpa;

import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.repository.CharacterRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CharacterJpaRepository extends JpaRepository<Character, UUID>, CharacterRepository {
}
