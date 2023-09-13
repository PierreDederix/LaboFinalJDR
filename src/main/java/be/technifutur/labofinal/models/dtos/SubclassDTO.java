package be.technifutur.labofinal.models.dtos;

import be.technifutur.labofinal.models.entities.Subclass;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubclassDTO {
    private Long id;
    private String name;
    private String job;
    private String description;

    public static SubclassDTO toDTO(Subclass entity) {
        if (entity == null) {
            return null;
        }

        return SubclassDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .job(entity.getJob().getName())
                .description(entity.getDescription())
                .build();
    }
}
