package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.entities.Scenario;
import be.technifutur.labofinal.repositories.CharacterRepository;
import be.technifutur.labofinal.repositories.ScenarioRepository;
import be.technifutur.labofinal.services.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final ScenarioRepository scenarioRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository, ScenarioRepository scenarioRepository) {
        this.characterRepository = characterRepository;
        this.scenarioRepository = scenarioRepository;
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
    public void assignScenario(Character character, Long id) {
        //TODO exceptions
        if (character.getScenario() != null) {
            throw new RuntimeException();
        }
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(RuntimeException::new);
        character.setScenario(scenario);
        characterRepository.save(character);
    }

    @Override
    public Integer getStatMod(Integer stat) {
        if (stat < 10) {
            return (stat-11)/2;
        }
        return (stat-10)/2;
    }

    @Override
    public void levelUp(Character character) {
        character.setLevel(character.getLevel()+1);
        character.setHp(
                character.getHp() +
                (character.getJob().getHpDiceValue()/2)+1 +
                getStatMod(character.getConstitution())
        );
        characterRepository.save(character);
    }
}

