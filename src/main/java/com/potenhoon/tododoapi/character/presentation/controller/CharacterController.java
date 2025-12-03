package com.potenhoon.tododoapi.character.presentation.controller;

import com.potenhoon.tododoapi.character.presentation.dto.CharacterCreateRequest;
import com.potenhoon.tododoapi.character.presentation.dto.CharacterResponse;
import com.potenhoon.tododoapi.character.application.service.CharacterService;
import org.springframework.http.CacheControl;
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
    public ResponseEntity<CharacterResponse> createCharacter(@RequestBody CharacterCreateRequest request) {
        CharacterResponse created = characterService.createCharacter(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable UUID userId) {
    CharacterResponse found = characterService.getCharacterById(userId);
        return ResponseEntity.ok(found); // userId는 테스트 목적으로 향후 변경 예정
    }
    
}
