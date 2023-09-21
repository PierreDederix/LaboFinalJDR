package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Scenario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ScenarioForm {

    @NotBlank
    private String name;

    @NotBlank
    private String synopsis;

    public Scenario toEntity() {
        Scenario scenario = new Scenario();
        scenario.setName(this.name);
        scenario.setSynopsis(this.synopsis);
        return scenario;
    }
}
