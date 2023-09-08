package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.forms.CharacterForm;
import be.technifutur.labofinal.services.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid CharacterForm form) {
        Character entity = form.toEntity();
        long body = characterService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }
}
