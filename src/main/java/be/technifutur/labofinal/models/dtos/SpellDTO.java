package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.Job;
import be.technifutur.labofinal.models.entities.Spell;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class SpellDTO {
    private Long id;
    private String name;
    private String description;
    private Integer spellLevel;
    private Set<String> availableJobs;

    public static SpellDTO toDTO(Spell entity) {
        if (entity == null) {
            return null;
        }

        return SpellDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .spellLevel(entity.getSpellLevel())
                .availableJobs(entity.getAvailableJobs().stream()
                        .map(Job::getName)
                        .collect(Collectors.toSet()))
                .build();
    }
}
