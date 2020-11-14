package ru.isf.mortgage.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.isf.mortgage.controller.dto.ResponseError;

import java.util.UUID;

@RestControllerAdvice(basePackages = "ru.isf.mortgage.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException e) {
        ResponseError responseError = new ResponseError(UUID.randomUUID(), e.getMessage(), "illegalArgumentException", "my-system");
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException e) {
        ResponseError responseError = new ResponseError(UUID.randomUUID(), e.getMessage(), "runtimeException", "my-system");
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
    }
}
