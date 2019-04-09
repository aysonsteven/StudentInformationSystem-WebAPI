package io.project.webapi.auth.user.validator;

import io.project.webapi.auth.user.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

    private  UserRepository userRepository;

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        return userRepository.findFirstByLogin(login).isPresent();
    }
}
