package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.Session;
import be.technifutur.labofinal.models.entities.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class SessionDTO {
    private Long id;
    private String name;
    private LocalDate sessionStart;
    private LocalDate sessionEnd;
    private Set<User> users;
    private String scenario;

    public static SessionDTO toDTO(Session entity) {
        if (entity == null) {
            return null;
        }

        return SessionDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .sessionStart(entity.getSessionStart())
                .sessionEnd(entity.getSessionEnd())
                .scenario(entity.getScenario().getName())
                .build();
    }
}
