package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.IncompatibleSubclassException;
import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.exceptions.ScenarioAlreadyAssigned;
import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.entities.Scenario;
import be.technifutur.labofinal.models.entities.Spell;
import be.technifutur.labofinal.models.entities.Subclass;
import be.technifutur.labofinal.repositories.CharacterRepository;
import be.technifutur.labofinal.repositories.ScenarioRepository;
import be.technifutur.labofinal.repositories.SpellRepository;
import be.technifutur.labofinal.services.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final ScenarioRepository scenarioRepository;
    private final SpellRepository spellRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository, ScenarioRepository scenarioRepository, SpellRepository spellRepository) {
        this.characterRepository = characterRepository;
        this.scenarioRepository = scenarioRepository;
        this.spellRepository = spellRepository;
    }


    @Override
    public Long add(Character character) {
        if (!character.getJob().getAvailableSubclasses().contains(character.getSubclass())) {
            throw new IncompatibleSubclassException(character.getJob().getId(),
                    character.getJob().getAvailableSubclasses().stream()
                            .map(Subclass::getId)
                            .toList()
            );
        }
        character.setMagicAvailable(character.getJob().getMagicAvailable() || character.getSubclass().getMagicAvailable());
        return characterRepository.save(character).getId();
    }

    @Override
    public Character getOne(Long id) {
        return characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Character.class));
    }

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public void update(Long id, Character character) {
        character.setId(id);
        if (!character.getJob().getAvailableSubclasses().contains(character.getSubclass())) {
            throw new IncompatibleSubclassException(character.getJob().getId(),
                    character.getJob().getAvailableSubclasses().stream()
                            .map(Subclass::getId)
                            .toList()
            );
        }
        character.setMagicAvailable(character.getJob().getMagicAvailable() || character.getSubclass().getMagicAvailable());
        characterRepository.save(character);
    }

    @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public void assignScenario(Character character, Long id) {
        if (character.getScenario() != null) {
            throw new ScenarioAlreadyAssigned(character.getScenario().getId());
        }
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Scenario.class));
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

    @Override
    public void addSpell(Character character, Long id) {
        Spell spell = spellRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Spell.class));
        character.getSpells().add(spell);
        characterRepository.save(character);
    }
}

