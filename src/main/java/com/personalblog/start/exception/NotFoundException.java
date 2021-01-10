package com.personalblog.start.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestErrorResponseException{

    public NotFoundException(ErrorResponse errorResponse) {
        super(HttpStatus.NOT_FOUND, errorResponse);
    }
}
