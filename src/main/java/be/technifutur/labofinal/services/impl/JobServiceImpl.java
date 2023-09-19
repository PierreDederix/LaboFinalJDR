package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ElementUsedOnCharacterException;
import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Job;
import be.technifutur.labofinal.repositories.CharacterRepository;
import be.technifutur.labofinal.repositories.JobRepository;
import be.technifutur.labofinal.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final CharacterRepository characterRepository;

    public JobServiceImpl(JobRepository jobRepository, CharacterRepository characterRepository) {
        this.jobRepository = jobRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Long add(Job job) {
        return jobRepository.save(job).getId();
    }

    @Override
    public Job getOne(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Job.class));
    }

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public void update(Long id, Job job) {
        job.setId(id);
        jobRepository.save(job);
    }

    @Override
    public void delete(Long id) {
        List<Long> characterJobId = characterRepository.findAll().stream()
                .filter(character -> Objects.equals(character.getJob().getId(), id))
                .map(character -> character.getJob().getId())
                .toList();
        if (!characterJobId.isEmpty()) {
            throw new ElementUsedOnCharacterException(characterJobId);
        }
        jobRepository.deleteById(id);
    }
}
