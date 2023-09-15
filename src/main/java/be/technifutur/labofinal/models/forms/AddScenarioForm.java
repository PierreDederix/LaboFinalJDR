package be.technifutur.labofinal.models.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddScenarioForm {
    @NotNull
    private Long id;
}
