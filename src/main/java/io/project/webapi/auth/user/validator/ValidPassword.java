package io.project.webapi.auth.user.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Retention(RUNTIME)
@Target({FIELD, ANNOTATION_TYPE, PARAMETER})
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {

    String message() default "{user.validation.password.characters}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}