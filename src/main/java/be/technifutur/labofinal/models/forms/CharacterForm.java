package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.entities.Scenario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class CharacterForm {

    @NotBlank
    private String name;

    @NotNull
    private Integer strength;

    @NotNull
    private Integer dexterity;

    @NotNull
    private Integer constitution;

    @NotNull
    private Integer intelligence;

    @NotNull
    private Integer wisdom;

    @NotNull
    private Integer charisma;

    @NotBlank
    private String job;

    private String subclass;

    public Character toEntity() {
        Character character = new Character();

        character.setName(this.name);
        character.setStrength(this.strength);
        character.setDexterity(this.dexterity);
        character.setConstitution(this.constitution);
        character.setIntelligence(this.intelligence);
        character.setWisdom(this.wisdom);
        character.setCharisma(this.charisma);

        return character;
    }
}
