package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Character;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CharacterForm {

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 6, message = "Stat's value can't be lower than 6")
    @Max(value = 20, message = "Stat's value can't be higher than 20")
    private Integer strength;

    @NotNull
    @Min(value = 6, message = "Stat's value can't be lower than 6")
    @Max(value = 20, message = "Stat's value can't be higher than 20")
    private Integer dexterity;

    @NotNull
    @Min(value = 6, message = "Stat's value can't be lower than 6")
    @Max(value = 20, message = "Stat's value can't be higher than 20")
    private Integer constitution;

    @NotNull
    @Min(value = 6, message = "Stat's value can't be lower than 6")
    @Max(value = 20, message = "Stat's value can't be higher than 20")
    private Integer intelligence;

    @NotNull
    @Min(value = 6, message = "Stat's value can't be lower than 6")
    @Max(value = 20, message = "Stat's value can't be higher than 20")
    private Integer wisdom;

    @NotNull
    @Min(value = 6, message = "Stat's value can't be lower than 6")
    @Max(value = 20, message = "Stat's value can't be higher than 20")
    private Integer charisma;

    @NotNull
    private Long jobId;

    @NotNull
    private Long subclassId;

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
