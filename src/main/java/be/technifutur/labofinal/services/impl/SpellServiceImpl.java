package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Spell;
import be.technifutur.labofinal.repositories.SpellRepository;
import be.technifutur.labofinal.services.SpellService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellServiceImpl implements SpellService {
    private final SpellRepository spellRepository;

    public SpellServiceImpl(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    @Override
    public Long add(Spell spell) {
        return spellRepository.save(spell).getId();
    }

    @Override
    public Spell getOne(Long id) {
        return spellRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Spell.class));
    }

    @Override
    public List<Spell> getAll() {
        return spellRepository.findAll();
    }

    @Override
    public void update(Long id, Spell spell) {
        spell.setId(id);
        spellRepository.save(spell);
    }

    @Override
    public void delete(Long id) {
        spellRepository.deleteById(id);
    }
}
