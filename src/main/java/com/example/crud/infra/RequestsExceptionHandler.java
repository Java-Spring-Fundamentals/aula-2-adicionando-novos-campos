package com.example.crud.infra;

import com.example.crud.domain.product.DistributionCenter;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RequestsExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> threat404(){
        ExceptionDTO response = new ExceptionDTO("Data not found with provided ID", 404);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> threatValidation(MethodArgumentNotValidException exception){
        String message = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return ResponseEntity.badRequest().body(new ExceptionDTO(message, 400));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> threatUnreadableBody(){
        String message = "Invalid request body. distributionCenter must be one of "
                + Arrays.toString(DistributionCenter.values());
        return ResponseEntity.badRequest().body(new ExceptionDTO(message, 400));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDTO> threatTypeMismatch(MethodArgumentTypeMismatchException exception){
        Class<?> requiredType = exception.getRequiredType();
        String accepted = requiredType != null && requiredType.isEnum()
                ? " Accepted values: " + Arrays.toString(requiredType.getEnumConstants())
                : "";
        String message = "Invalid value for parameter " + exception.getName() + "." + accepted;
        return ResponseEntity.badRequest().body(new ExceptionDTO(message, 400));
    }
}
