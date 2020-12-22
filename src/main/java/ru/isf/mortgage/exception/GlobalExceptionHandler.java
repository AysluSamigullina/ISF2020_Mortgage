package ru.isf.mortgage.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.isf.mortgage.controller.dto.ResponseError;
import ru.isf.mortgage.validator.RequestDtoValidator;

import java.util.List;

@RestControllerAdvice(basePackages = "ru.isf.mortgage.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public List<ResponseError> exc(Exception e) {
        return RequestDtoValidator.errorList;
    }
}
