package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Spell;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class SpellForm {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Min(0)
    @Max(9)
    private Integer spellLevel;

    @NotBlank
    private Set<Long> availableJobs;

    public Spell toEntity() {
        Spell spell = new Spell();
        spell.setName(this.name);
        spell.setDescription(this.description);
        spell.setSpellLevel(this.spellLevel);
        return spell;
    }
}
