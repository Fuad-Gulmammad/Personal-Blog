package com.personalblog.start.exception;

import org.springframework.http.HttpStatus;

public class RestErrorResponseException extends RuntimeException{

    private final HttpStatus httpStatus;
    private final ErrorResponse errorResponse;

    public RestErrorResponseException(HttpStatus httpStatus, ErrorResponse errorResponse) {
        this.httpStatus = httpStatus;
        this.errorResponse = errorResponse;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public String toString() {
        return "RestErrorResponseException{" +
                "httpStatus=" + httpStatus +
                ", errorResponse=" + errorResponse +
                '}';
    }
}
