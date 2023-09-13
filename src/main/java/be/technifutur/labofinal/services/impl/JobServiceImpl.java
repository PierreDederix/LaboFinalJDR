package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.models.entities.Job;
import be.technifutur.labofinal.repositories.JobRepository;
import be.technifutur.labofinal.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Long add(Job job) {
        return jobRepository.save(job).getId();
    }

    @Override
    public Job getOne(Long id) {
        // TODO EXCEPTION
        return jobRepository.findById(id).orElseThrow(RuntimeException::new);
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
        jobRepository.deleteById(id);
    }
}
