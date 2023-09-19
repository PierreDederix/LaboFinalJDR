package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Session;
import be.technifutur.labofinal.validation.constraints.SequentialDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@SequentialDate
public class SessionForm {

    @NotBlank
    private String name;

    @NotNull
    private LocalDate sessionStart;

    @NotNull
    private LocalDate sessionEnd;

    @NotNull
    private Long scenarioId;

    public Session toEntity() {
        Session entity = new Session();
        entity.setName(this.name);
        entity.setSessionStart(this.sessionStart);
        entity.setSessionEnd(this.sessionStart);
        return entity;
    }
}
