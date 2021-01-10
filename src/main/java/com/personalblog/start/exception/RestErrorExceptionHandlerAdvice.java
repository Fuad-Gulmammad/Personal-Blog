package com.personalblog.start.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorExceptionHandlerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException notFoundException){
        System.out.println(notFoundException.getErrorResponse());
        return ResponseEntity.status(notFoundException.getHttpStatus()).body(notFoundException.getErrorResponse());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException badRequestException){
        return ResponseEntity.status(badRequestException.getHttpStatus()).body(badRequestException.getErrorResponse());
    }

    @ExceptionHandler(RestErrorResponseException.class)
    public ResponseEntity<ErrorResponse> handleRestErrorResponseException(RestErrorResponseException restErrorResponseException){
        return ResponseEntity.status(restErrorResponseException.getHttpStatus()).body(restErrorResponseException.getErrorResponse());
    }

}
