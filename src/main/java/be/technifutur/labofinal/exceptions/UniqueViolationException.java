package be.technifutur.labofinal.exceptions;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;

@Getter
public class UniqueViolationException extends RuntimeException{

    private final Collection<String> fieldNames;

    public UniqueViolationException(String... fieldNames) {
        this(null, Arrays.stream(fieldNames).toList());
    }

    public UniqueViolationException(Collection<String> fieldNames) {
        this(null, fieldNames);
    }

    public UniqueViolationException(Throwable cause, Collection<String> fieldName) {
        super("{%s} should be unique".formatted(fieldName), cause);
        this.fieldNames = fieldName;
    }
}
