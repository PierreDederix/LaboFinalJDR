package be.technifutur.labofinal.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class JobUsedOnCharacterException extends RuntimeException{
    private final List<Long> ids;

    public JobUsedOnCharacterException(List<Long> ids) {
        super("This job is still used on one or more characters with id : ");

        this.ids = ids;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder(super.getMessage());

        for (Object obj : ids) {
            message.append(obj).append(", ");
        }

        // Supprimez la virgule en trop à la fin
        if (!ids.isEmpty()) {
            message.delete(message.length() - 2, message.length());
        }

        return message.toString();
    }
}
