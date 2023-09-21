package be.technifutur.labofinal.models.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserIdForm {
    @NotNull
    private Long id;
}
