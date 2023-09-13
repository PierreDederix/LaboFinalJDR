package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Subclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubclassForm {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Long jobId;

    public Subclass toEntity() {
        Subclass subclass = new Subclass();
        subclass.setName(this.name);
        subclass.setDescription(this.description);
        return subclass;
    }

}
