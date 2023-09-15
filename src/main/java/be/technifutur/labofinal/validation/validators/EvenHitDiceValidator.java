package be.technifutur.labofinal.validation.validators;

import be.technifutur.labofinal.validation.constraints.EvenHitDice;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenHitDiceValidator implements ConstraintValidator<EvenHitDice, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value%2 == 0;
    }
}
