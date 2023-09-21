package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.Character;
import be.technifutur.labofinal.models.entities.Scenario;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ScenarioDTO {
    private Long id;
    private String name;
    private String synopsis;
    private Set<String> characterNames;

    public static ScenarioDTO toDTO(Scenario entity) {
        if (entity == null) {
            return null;
        }

        return ScenarioDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .synopsis(entity.getSynopsis())
                .characterNames(entity.getCharacters().stream()
                        .map(Character::getName)
                        .collect(Collectors.toSet()))
                .build();
    }
}
