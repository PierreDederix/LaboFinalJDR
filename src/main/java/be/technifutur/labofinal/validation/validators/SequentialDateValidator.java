package be.technifutur.labofinal.validation.validators;

import be.technifutur.labofinal.models.forms.SessionForm;
import be.technifutur.labofinal.validation.constraints.SequentialDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SequentialDateValidator implements ConstraintValidator<SequentialDate, SessionForm> {
    @Override
    public boolean isValid(SessionForm session, ConstraintValidatorContext context) {

        if(session.getSessionStart() == null ||
                session.getSessionEnd() == null) {
            return false;
        }

        return session.getSessionStart().isBefore(session.getSessionEnd());
    }
}
