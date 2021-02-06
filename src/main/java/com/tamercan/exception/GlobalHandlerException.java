package com.tamercan.exception;

import com.tamercan.Entity.APIError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleConstraintViolation(UserNotFoundException ex) {
        APIError apiError = new APIError.Builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .errorCode(1)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(APIError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(AuthenticateException.class)
    protected ResponseEntity<Object> handleConstraintViolation(AuthenticateException ex) {
        APIError apiError = new APIError.Builder()
                .httpStatus(HttpStatus.FORBIDDEN)
                .errorCode(2)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(PasswordNotValidException.class)
    protected ResponseEntity<Object> handleConstraintViolation(PasswordNotValidException ex) {
        APIError apiError = new APIError.Builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .errorCode(3)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    protected ResponseEntity<Object> handleConstraintViolation(UserAlreadyExistException ex) {
        APIError apiError = new APIError.Builder()
                .httpStatus(HttpStatus.CONFLICT)
                .errorCode(4)
                .message(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> customErr = new ArrayList<>();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors())
            customErr.add(objectError.getDefaultMessage());

        APIError apiError = new APIError.Builder()
                .httpStatus(status)
                .errorCode(21)
                .message("Validation Error")
                .path(request.toString())
                .errorDetails(customErr).build();
        return buildResponseEntity(apiError);
    }

}
