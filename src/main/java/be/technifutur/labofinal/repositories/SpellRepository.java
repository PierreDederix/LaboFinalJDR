package be.technifutur.labofinal.repositories;

import be.technifutur.labofinal.models.entities.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository extends JpaRepository<Spell, Long> {
}
