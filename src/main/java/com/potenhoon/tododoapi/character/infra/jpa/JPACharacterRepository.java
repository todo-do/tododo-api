package com.potenhoon.tododoapi.character.infra.jpa;

import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.repository.CharacterRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JPACharacterRepository implements CharacterRepository {

    private final CharacterJpaRepository repository;

    public JPACharacterRepository(CharacterJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Character save(Character character) {
        return repository.save(character);
    }

    @Override
    public Optional<Character> findById(UUID id) {
        return repository.findById(id);
    }
}
