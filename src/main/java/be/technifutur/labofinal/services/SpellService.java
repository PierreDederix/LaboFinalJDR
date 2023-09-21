package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Spell;

import java.util.List;

public interface SpellService {
    Long add(Spell spell);
    Spell getOne(Long id);
    List<Spell> getAll();
    void update(Long id, Spell spell);
    void delete(Long id);
}
