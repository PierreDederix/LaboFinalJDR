package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private Set<String> roles;
    private Set<String> status;

    public static UserDTO toDTO(User entity) {
        if (entity == null) {
            return null;
        }

        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .roles(entity.getRoles().stream()
                        .map(Enum::toString)
                        .collect(Collectors.toSet())
                )
                .status(entity.getStatus().stream()
                        .map(Enum::toString)
                        .collect(Collectors.toSet())
                )
                .build();
    }
}
