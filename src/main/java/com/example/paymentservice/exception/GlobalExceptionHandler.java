package com.example.paymentservice.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Invalid argument");
        response.put("message", e.getMessage());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidFormatException(InvalidFormatException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Invalid format");
        String message = ex.getValue() + " is not a valid value for " + ex.getTargetType().getSimpleName();
        response.put("message", message);
        return response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Constraint violation");
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Map<String, String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Method not allowed");
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Missing request parameter");
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Entity not found");
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleException(Exception ex) {
        if (ex.getCause() instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) ex.getCause());
        }

        Map<String, String> response = new HashMap<>();
        response.put("error", "An unexpected error occurred");
        response.put("message", ex.getMessage());
        return response;
    }
}
