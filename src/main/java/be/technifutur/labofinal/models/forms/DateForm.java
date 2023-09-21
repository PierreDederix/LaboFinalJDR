package be.technifutur.labofinal.models.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DateForm {
    @NotNull
    private LocalDate sessionStart;

    @NotNull
    private LocalDate sessionEnd;
}
