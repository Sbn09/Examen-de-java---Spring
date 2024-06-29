package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionInterceptor {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Map<String, Object> erreurConflitSql() {
        return Map.of("erreur", "Erreur SQL sur une contrainte");
    }
}
