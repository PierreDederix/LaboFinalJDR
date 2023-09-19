package be.technifutur.labofinal.exceptions;

import lombok.Getter;

@Getter
public class ScenarioAlreadyAssigned extends RuntimeException{
    private final Object id;

    public ScenarioAlreadyAssigned(Object id) {
        super("This character is already assigned to the scenatio with id {%s}".formatted(id));
        this.id = id;
    }
}
