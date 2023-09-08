package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.repositories.CharacterRepository;
import be.technifutur.labofinal.services.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @Override
    public Long add(Character character) {
        return characterRepository.save(character).getId();
    }

    @Override
    public Character getOne(Long id) {
        // TODO EXCEPTION
        return characterRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public void update(Long id, Character character) {
        character.setId(id);
        characterRepository.save(character);
    }

    @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public void levelUp() {

    }
}