package com.usermanagment.user_managment_ms.exception;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message) {
        super(message);
    }
}
