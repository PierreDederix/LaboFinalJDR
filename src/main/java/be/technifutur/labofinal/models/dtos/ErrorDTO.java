package be.technifutur.labofinal.models.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class ErrorDTO {

    private String uri;
    private String method;
    private Set<Map<String, Object>> errors;
}
