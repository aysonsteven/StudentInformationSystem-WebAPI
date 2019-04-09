package io.project.webapi.auth.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class ValidationExceptionHandler {

    private static final String VALIDATION_FAILED_KEY = "validationFailed";

    private  MessageSource messageSource;
    private  HttpServletRequest request;

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void handleValidationExceptions(MethodArgumentNotValidException ex) {

    }
}
