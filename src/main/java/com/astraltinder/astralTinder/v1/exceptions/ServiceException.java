
package com.astraltinder.astralTinder.v1.exceptions;

public class ServiceException extends Exception {

   String message;

    public ServiceException(String message) {
        super(message);
    }
   
}   
