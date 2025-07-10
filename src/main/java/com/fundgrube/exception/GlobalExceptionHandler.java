package com.fundgrube.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Globaler Exception-Handler für die Anwendung.
 *
 * Diese Klasse ist nötig, um Validierungsfehler (z.B. bei @Valid in Controllern)
 * zentral abzufangen und dem Client eine verständliche Fehlermeldung im JSON-Format
 * zurückzugeben. Ohne diese Klasse würde Spring Boot Standard-Fehlerseiten oder
 * wenig hilfreiche Fehlermeldungen liefern.
 *
 * Vorteil: Alle Validierungsfehler werden einheitlich als Map<field, message> mit
 * Status 400 (Bad Request) zurückgegeben. Das erleichtert die Fehlerbehandlung im Frontend.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Fängt alle MethodArgumentNotValidException ab, die bei Validierungsfehlern
     * (z.B. durch @Valid in @RequestBody) ausgelöst werden.
     *
     * @param ex Die ausgelöste Exception
     * @return ResponseEntity mit Map aller Feld-Fehlermeldungen und Status 400
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
