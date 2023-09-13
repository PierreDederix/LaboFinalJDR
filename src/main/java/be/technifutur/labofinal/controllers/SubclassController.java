package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.SubclassDTO;
import be.technifutur.labofinal.models.entities.Subclass;
import be.technifutur.labofinal.models.forms.SubclassForm;
import be.technifutur.labofinal.services.JobService;
import be.technifutur.labofinal.services.SubclassService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subclass")
public class SubclassController {
    private SubclassService subclassService;
    private JobService jobService;

    public SubclassController(SubclassService subclassService, JobService jobService) {
        this.subclassService = subclassService;
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid SubclassForm form) {
        Subclass entity = form.toEntity();
        entity.setJob(jobService.getOne(form.getJobId()));
        Long body = subclassService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<SubclassDTO> getOne(@PathVariable Long id){
        Subclass subclass = subclassService.getOne(id);
        SubclassDTO body = SubclassDTO.toDTO(subclass);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<SubclassDTO>> getAll() {
        List<Subclass> jobs = subclassService.getAll();
        List<SubclassDTO> body = jobs.stream()
                .map(SubclassDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid SubclassForm form) {
        subclassService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        subclassService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
