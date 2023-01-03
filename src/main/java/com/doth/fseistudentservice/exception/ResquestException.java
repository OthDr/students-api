package com.doth.fseistudentservice.exception;

public class ResquestException extends RuntimeException{

    public ResquestException(String message) {
        super(message);
    }

    public ResquestException(String message, Throwable cause) {
        super(message, cause);
    }

}
