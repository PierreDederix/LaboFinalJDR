package be.technifutur.labofinal.validation.constraints;

import be.technifutur.labofinal.validation.validators.SequentialDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = SequentialDateValidator.class)
public @interface SequentialDate {
    String message() default "The date should be sequential";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
