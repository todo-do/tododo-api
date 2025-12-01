package com.potenhoon.tododoapi.character.presentation.controller;

import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;
import com.potenhoon.tododoapi.character.presentation.dto.StatsRequest;
import com.potenhoon.tododoapi.character.domain.model.Character;
import com.potenhoon.tododoapi.character.domain.model.Stats;
import com.potenhoon.tododoapi.character.application.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<CharacterResponse> create(@RequestBody CharacterCreateRequest request) {
        Stats stats = resolveStats(request.stats());
        Character created = characterService.create(request.name(), stats);
        return ResponseEntity.ok(CharacterResponse.from(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponse> get(@PathVariable UUID id) {
        Character found = characterService.get(id);
        return ResponseEntity.ok(CharacterResponse.from(found));
    }

    private Stats resolveStats(StatsRequest statsRequest) {
        return statsRequest == null ? Stats.zero() : statsRequest.toStats();
    }
}
