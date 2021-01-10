package com.personalblog.start.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestErrorResponseException {
    public BadRequestException( ErrorResponse errorResponse) {
        super(HttpStatus.BAD_REQUEST , errorResponse);
    }
}
