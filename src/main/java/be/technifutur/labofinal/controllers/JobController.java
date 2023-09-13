package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.JobDTO;
import be.technifutur.labofinal.models.entities.Job;
import be.technifutur.labofinal.models.forms.JobForm;
import be.technifutur.labofinal.services.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid JobForm form) {
        Job entity = form.toEntity();
        Long body = jobService.add(entity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(body);
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<JobDTO> getOne(@PathVariable Long id){
        Job job = jobService.getOne(id);
        JobDTO body = JobDTO.toDTO(job);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAll() {
        List<Job> jobs = jobService.getAll();
        List<JobDTO> body = jobs.stream()
                .map(JobDTO::toDTO)
                .toList();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody @Valid JobForm form) {
        jobService.update(id, form.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        jobService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
