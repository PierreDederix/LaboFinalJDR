package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Job;

import java.util.List;

public interface JobService {
    Long add(Job job);
    Job getOne(Long id);
    List<Job> getAll();
    void update(Long id, Job job);
    void delete(Long id);
}
