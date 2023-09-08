package be.technifutur.labofinal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResourceNotFoundException extends ResponseStatusException {

    private final Object id;
    private final Class<?> resourceClass;
    public ResourceNotFoundException(Object id, Class<?> resourceClass) {
        super(HttpStatus.NOT_FOUND, "Cannot find resource of type {%s} with id {%s}".formatted(resourceClass.getSimpleName(), id.toString()));
        this.id = id;
        this.resourceClass = resourceClass;
    }
}
