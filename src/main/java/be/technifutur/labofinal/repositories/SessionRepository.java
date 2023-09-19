package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
