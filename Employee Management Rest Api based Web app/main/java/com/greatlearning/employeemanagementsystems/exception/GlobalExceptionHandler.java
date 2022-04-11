package com.greatlearning.employeemanagementsystems.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public Error handleInvalidEmployeeId(IllegalArgumentException exception){
      log.error("Exception while fetching employee with invalid id {}", exception.getMessage());
      return new Error(100, exception.getMessage());
    }
}


@Getter
@AllArgsConstructor
class Error {
    private int code;
    private String message;
}
