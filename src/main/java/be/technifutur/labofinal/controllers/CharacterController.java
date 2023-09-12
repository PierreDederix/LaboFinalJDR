package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.CharacterDTO;
import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.forms.CharacterForm;
import be.technifutur.labofinal.repositories.JobRepository;
import be.technifutur.labofinal.repositories.SubclassRepository;
import be.technifutur.labofinal.services.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;
    private final JobRepository jobRepository;
    private final SubclassRepository subclassRepository;

    public CharacterController(CharacterService characterService, JobRepository jobRepository, SubclassRepository subclassRepository) {
        this.characterService = characterService;
        this.jobRepository = jobRepository;
        this.subclassRepository = subclassRepository;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid CharacterForm form) {
        Character entity = form.toEntity();
        entity.setLevel(1);
        entity.setJob(jobRepository.findByName(form.getJob()).orElseThrow(RuntimeException::new));
        entity.setSubclass(subclassRepository.findByName(form.getSubclass()).orElseThrow(RuntimeException::new));
        entity.setHp(entity.getJob().getHpDiceValue() + characterService.getStatMod(entity.getConstitution()));
        long body = characterService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CharacterDTO> getOne(@PathVariable Long id) {
        Character character = characterService.getOne(id);
        CharacterDTO body = CharacterDTO.toDTO(character);
        return ResponseEntity.ok(body);
    }
}
