package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByName(String username);
    boolean existsByName(String username);
}
