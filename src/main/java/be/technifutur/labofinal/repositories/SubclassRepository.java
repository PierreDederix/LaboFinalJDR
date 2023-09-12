package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubclassRepository extends JpaRepository<Subclass, Long> {
    Optional<Subclass> findByName(String name);
}
