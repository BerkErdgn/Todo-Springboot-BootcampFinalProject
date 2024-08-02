package com.berkerdgn.Todo_Springboot_BootcampFinalProject.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import java.util.List;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueTodoValidation.class })
public @interface AUniqueTodo {
    String message() default "Aynı todo zaten var.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
