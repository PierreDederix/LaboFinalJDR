package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.exceptions.*;
import be.technifutur.labofinal.models.dtos.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handle(ResourceNotFoundException ex, HttpServletRequest req) {

        String uri = req.getRequestURI();
        String method = req.getMethod();

        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("id", ex.getId());
        error.put("resourceType", ex.getResourceClass().getSimpleName());

        ErrorDTO body = ErrorDTO.builder()
                .uri(uri)
                .method(method)
                .errors(Set.of(error))
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }

    @ExceptionHandler(UniqueViolationException.class)
    public ResponseEntity<ErrorDTO> handle(UniqueViolationException ex, HttpServletRequest req) {
        String uri = req.getRequestURI();
        String method = req.getMethod();

        Set<Map<String, Object>> errors = new LinkedHashSet<>();
        ex.getFieldNames().forEach(
                field -> {
                    Map<String, Object> errorData = new HashMap<>();
                    errorData.put(field, "should be unique");
                    errors.add(errorData);
                }
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorDTO.builder()
                        .uri(uri)
                        .method(method)
                        .errors(errors)
                        .build()
                );

    }

    @ExceptionHandler(ScenarioAlreadyAssigned.class)
    public ResponseEntity<ErrorDTO> handle(ScenarioAlreadyAssigned ex, HttpServletRequest req) {
        String uri = req.getRequestURI();
        String method = req.getMethod();

        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("id", ex.getId());

        ErrorDTO body = ErrorDTO.builder()
                .uri(uri)
                .method(method)
                .errors(Set.of(error))
                .build();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }

    @ExceptionHandler(ElementUsedOnCharacterException.class)
    public ResponseEntity<ErrorDTO> handle(ElementUsedOnCharacterException ex, HttpServletRequest req) {
        String uri = req.getRequestURI();
        String method = req.getMethod();

        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("ids", ex.getIds());

        ErrorDTO body = ErrorDTO.builder()
                .uri(uri)
                .method(method)
                .errors(Set.of(error))
                .build();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }

    @ExceptionHandler(IncompatibleSubclassException.class)
    public ResponseEntity<ErrorDTO> handle(IncompatibleSubclassException ex, HttpServletRequest req) {
        String uri = req.getRequestURI();
        String method = req.getMethod();

        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("jobId", ex.getJobId());
        error.put("SubclassesId", ex.getSubclassesId());

        ErrorDTO body = ErrorDTO.builder()
                .uri(uri)
                .method(method)
                .errors(Set.of(error))
                .build();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(body);
    }
}
