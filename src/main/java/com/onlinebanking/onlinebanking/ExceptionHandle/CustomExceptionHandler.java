package com.onlinebanking.onlinebanking.ExceptionHandle;

import com.onlinebanking.onlinebanking.Dto.ExceptionHandle.ExceptionError;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = {ResourcesNotFound.class})
  ResponseEntity<Object> notFoundExceptionHandler(ResourcesNotFound e) {
    ExceptionError exceptionError =
        new ExceptionError(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
    return new ResponseEntity<>(exceptionError, HttpStatus.NOT_FOUND);
  }
}
