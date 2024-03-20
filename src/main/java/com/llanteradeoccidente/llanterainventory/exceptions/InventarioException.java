package com.llanteradeoccidente.llanterainventory.exceptions;

import org.springframework.http.HttpStatus;

public class InventarioException extends RuntimeException{
    private final HttpStatus httpStatus;

    public InventarioException(String message) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public InventarioException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


}
