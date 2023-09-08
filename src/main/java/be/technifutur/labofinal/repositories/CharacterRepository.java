package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
