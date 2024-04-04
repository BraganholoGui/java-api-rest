package br.com.api.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MedicoExistsValidator.class)
@Documented
public @interface MedicoExists {
    String message() default "Médico não encontrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
