package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.SessionDTO;
import be.technifutur.labofinal.models.entities.Session;
import be.technifutur.labofinal.models.forms.SessionForm;
import be.technifutur.labofinal.services.CharacterService;
import be.technifutur.labofinal.services.ScenarioService;
import be.technifutur.labofinal.services.SessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    private final SessionService sessionService;
    private final ScenarioService scenarioService;
    private final CharacterService characterService;

    public SessionController(SessionService sessionService, ScenarioService scenarioService, CharacterService characterService) {
        this.sessionService = sessionService;
        this.scenarioService = scenarioService;
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid SessionForm form) {
        Session entity = form.toEntity();
        entity.setScenario(scenarioService.getOne(form.getScenarioId()));
        Long body = sessionService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<SessionDTO> getOne(@PathVariable Long id){
        Session session = sessionService.getOne(id);
        SessionDTO body = SessionDTO.toDTO(session);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> getAll() {
        List<Session> sessions = sessionService.getAll();
        List<SessionDTO> body = sessions.stream()
                .map(SessionDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid SessionForm form) {
        sessionService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
