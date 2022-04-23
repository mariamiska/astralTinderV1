package com.astralTinderV1.exceptions;

public class ServiceException extends Exception {

   String message;

    public ServiceException(String message) {
        super(message);
    }
   
}   
