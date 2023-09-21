package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.SpellDTO;
import be.technifutur.labofinal.models.entities.Spell;
import be.technifutur.labofinal.models.forms.SpellForm;
import be.technifutur.labofinal.services.SpellService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spell")
public class SpellController {

    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid SpellForm form) {
        Spell entity = form.toEntity();
        Long body = spellService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<SpellDTO> getOne(@PathVariable Long id){
        Spell spell = spellService.getOne(id);
        SpellDTO body = SpellDTO.toDTO(spell);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<SpellDTO>> getAll() {
        List<Spell> spells = spellService.getAll();
        List<SpellDTO> body = spells.stream()
                .map(SpellDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid SpellForm form) {
        spellService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        spellService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
