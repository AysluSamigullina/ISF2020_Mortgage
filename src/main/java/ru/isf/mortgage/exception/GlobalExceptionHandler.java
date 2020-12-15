package ru.isf.mortgage.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.isf.mortgage.controller.dto.ResponseError;
import ru.isf.mortgage.validator.RequestDtoValidator;

import java.util.List;

@RestControllerAdvice(basePackages = "ru.isf.mortgage.controller")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler({IllegalArgumentException.class})
//    public List<ResponseError> illegalArgumentException(IllegalArgumentException e) {
//        ResponseError responseError = new ResponseError(UUID.randomUUID(), e.getMessage(), "illegalArgumentException", "my-system");
//        errorList.add(responseError);
//        return errorList;
//  //      return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ResponseError> runtimeException(RuntimeException e) {
//        ResponseError responseError = new ResponseError(UUID.randomUUID(), e.getMessage(), "runtimeException", "my-system");
//        errorList.add(responseError);
//        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
//    }

    @ExceptionHandler(RuntimeException.class)
    public List<ResponseError> exc(Exception e) {
        return RequestDtoValidator.errorList;
    }
}
