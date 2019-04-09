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
@Constraint(validatedBy = UniqueLoginValidator.class)
public @interface UniqueLogin {

    String message() default "{user.validation.login.notUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
