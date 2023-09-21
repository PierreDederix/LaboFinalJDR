package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.ScenarioDTO;
import be.technifutur.labofinal.models.entities.Scenario;
import be.technifutur.labofinal.models.forms.ScenarioForm;
import be.technifutur.labofinal.services.ScenarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scenario")
public class ScenarioController {
    private final ScenarioService scenarioService;

    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid ScenarioForm form) {
        Scenario entity = form.toEntity();
        Long body = scenarioService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<ScenarioDTO> getOne(@PathVariable Long id){
        Scenario scenario = scenarioService.getOne(id);
        ScenarioDTO body = ScenarioDTO.toDTO(scenario);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<ScenarioDTO>> getAll() {
        List<Scenario> scenarios = scenarioService.getAll();
        List<ScenarioDTO> body = scenarios.stream()
                .map(ScenarioDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ScenarioForm form) {
        scenarioService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        scenarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
