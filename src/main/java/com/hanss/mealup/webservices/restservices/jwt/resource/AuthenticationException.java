package com.hanss.mealup.webservices.restservices.jwt.resource;
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

