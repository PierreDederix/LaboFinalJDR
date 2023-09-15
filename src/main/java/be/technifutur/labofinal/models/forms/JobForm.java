package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Job;
import be.technifutur.labofinal.validation.constraints.EvenHitDice;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobForm {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Min(value = 6, message = "Dice's value should be between 6 and 12")
    @Max(value = 12, message = "Dice's value should be between 6 and 12")
    @EvenHitDice(message = "Dice's value should be a multiple of 2")
    private Integer hpDiceValue;

    public Job toEntity() {
        Job job = new Job();
        job.setName(this.name);
        job.setDescription(this.description);
        job.setHpDiceValue(this.hpDiceValue);
        return job;
    }
}
