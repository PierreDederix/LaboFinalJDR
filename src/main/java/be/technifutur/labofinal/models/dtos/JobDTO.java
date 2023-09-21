package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.Job;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDTO {
    private Long id;
    private String name;
    private String description;
    private String hpDiceValue;
    private Boolean magicAvailable;

    public static JobDTO toDTO(Job entity) {
        if (entity == null) {
            return null;
        }

        return JobDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .hpDiceValue("1d" + entity.getHpDiceValue())
                .magicAvailable(entity.getMagicAvailable())
                .build();
    }
}
