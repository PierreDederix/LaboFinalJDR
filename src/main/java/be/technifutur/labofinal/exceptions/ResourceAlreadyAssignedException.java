package be.technifutur.labofinal.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class ResourceAlreadyAssignedException extends ResponseStatusException {
    private final Object id;
    private final Class<?> resourceClass;

    public ResourceAlreadyAssignedException(Object id, Class<?> resourceClass) {
        super(HttpStatus.CONFLICT, "Resource of type {%s} with id {%s} has already been added to this entity".formatted(resourceClass.getSimpleName(), id.toString()));
        this.id = id;
        this.resourceClass = resourceClass;
    }
}
