package be.technifutur.labofinal.models.forms;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddScenarioForm {
    @NotBlank
    private Long id;
}
