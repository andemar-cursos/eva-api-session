package com.pichincha.eva.session.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> generalException(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder()
        .timestamp(new Date())
        .message(ex.getMessage())
        .details(request.getDescription(false))
        .build();
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EmptyUserException.class)
  public final ResponseEntity<Object> emptyUserException(EmptyUserException ex, WebRequest request) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder()
        .timestamp(new Date())
        .message(ex.getMessage())
        .details(request.getDescription(false))
        .build();
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EmptyPasswordException.class)
  public final ResponseEntity<Object> emptyUserException(EmptyPasswordException ex, WebRequest request) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder()
        .timestamp(new Date())
        .message(ex.getMessage())
        .details(request.getDescription(false))
        .build();
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
