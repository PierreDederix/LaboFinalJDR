package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.CharacterDTO;
import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.forms.AddScenarioForm;
import be.technifutur.labofinal.models.forms.CharacterForm;
import be.technifutur.labofinal.services.CharacterService;
import be.technifutur.labofinal.services.JobService;
import be.technifutur.labofinal.services.SubclassService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;
    private final JobService jobService;
    private final SubclassService subclassService;

    public CharacterController(CharacterService characterService, JobService jobService, SubclassService subclassService) {
        this.characterService = characterService;
        this.jobService = jobService;
        this.subclassService = subclassService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid CharacterForm form) {
        Character entity = form.toEntity();
        entity.setLevel(1);
        entity.setJob(jobService.getOne(form.getJob()));
        entity.setSubclass(subclassService.getOne(form.getSubclass()));
        entity.setHp(entity.getJob().getHpDiceValue() + characterService.getStatMod(entity.getConstitution()));
        Long body = characterService.add(entity);
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

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAll() {
        List<Character> characters = characterService.getAll();
        List<CharacterDTO> body = characters.stream()
                .map(CharacterDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid CharacterForm form) {
        characterService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id:[0-9]+}/levelup")
    public ResponseEntity<CharacterDTO> levelUp(@PathVariable Long id) {
        Character character = characterService.getOne(id);
        characterService.levelUp(character);
        CharacterDTO body = CharacterDTO.toDTO(character);
        return ResponseEntity.ok(body);
    }

    @PatchMapping("/{id:[0-9]+}/scenario")
    public ResponseEntity<?> addScenario(@PathVariable Long id, @RequestBody @Valid AddScenarioForm form) {
        characterService.assignScenario(characterService.getOne(id), form.getId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        characterService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
