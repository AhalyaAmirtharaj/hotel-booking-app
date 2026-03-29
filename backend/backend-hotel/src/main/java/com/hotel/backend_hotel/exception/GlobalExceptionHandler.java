package com.hotel.backend_hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(RuntimeException.class)
public ResponseEntity handleError(RuntimeException ex) {
Map error = new HashMap();
error.put("message", ex.getMessage());
return ResponseEntity.badRequest().body(error);
}
}