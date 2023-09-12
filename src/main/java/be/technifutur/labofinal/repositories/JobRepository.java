package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findByName(String name);
}
