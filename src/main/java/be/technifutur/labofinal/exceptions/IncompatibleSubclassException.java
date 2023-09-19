package be.technifutur.labofinal.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class IncompatibleSubclassException extends RuntimeException{
    private final Object jobId;
    private final List<Long> subclassesId;

    public IncompatibleSubclassException(Object jobId, List<Long> subclassesId) {
        super("Characters having a job with id %s should cannot have a subclass other than those with id : ".formatted(jobId));
        this.jobId = jobId;
        this.subclassesId = subclassesId;
    }
    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder(super.getMessage());

        for (Object obj : subclassesId) {
            message.append(obj).append(", ");
        }

        // Supprimez la virgule en trop à la fin
        if (!subclassesId.isEmpty()) {
            message.delete(message.length() - 2, message.length());
        }

        return message.toString();
    }

}
