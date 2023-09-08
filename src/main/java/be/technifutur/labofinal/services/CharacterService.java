package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Character;

import java.util.List;

public interface CharacterService {
    Long add(Character character);
    Character getOne(Long id);
    List<Character> getAll();
    void update(Long id, Character character);
    void delete(Long id);
    void levelUp();
}
