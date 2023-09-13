package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Job;
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
    private Integer hpDiceValue;

    public Job toEntity() {
        Job job = new Job();
        job.setName(this.name);
        job.setDescription(this.description);
        job.setHpDiceValue(this.hpDiceValue);
        return job;
    }
}
