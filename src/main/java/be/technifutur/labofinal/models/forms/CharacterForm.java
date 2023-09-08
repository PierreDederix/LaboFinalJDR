package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.entities.Job;
import be.technifutur.labofinal.models.entities.Scenario;
import be.technifutur.labofinal.models.entities.Spell;
import be.technifutur.labofinal.models.entities.Subclass;
import lombok.Data;

import java.util.Set;

@Data
public class CharacterForm {
    private String name;
    private Integer level;
    private Integer hp;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Job job;
    private Subclass subclass;
    private Set<Spell> spells;
    private Scenario scenario;

    public Character toEntity() {
        Character character = new Character();

        character.setName(this.name);
        character.setLevel(this.level);
        character.setHp(this.hp);
        character.setStrength(this.strength);
        character.setDexterity(this.dexterity);
        character.setConstitution(this.constitution);
        character.setIntelligence(this.intelligence);
        character.setWisdom(this.wisdom);
        character.setCharisma(this.charisma);
        character.setJob(this.job);
        character.setSubclass(this.subclass);
        character.setSpells(this.spells);
        character.setScenario(this.scenario);

        return character;
    }
}
