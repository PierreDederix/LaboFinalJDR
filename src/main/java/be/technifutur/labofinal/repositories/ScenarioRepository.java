package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
}
