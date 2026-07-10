package com.exemplo.user.exception;

public class EmailAlreadyUsedException extends RuntimeException {

    public EmailAlreadyUsedException(String email) {
        super("The email '" + email + "' is already registered in the system.");
    }

    public EmailAlreadyUsedException(String email, Throwable cause) {
        super("The email '" + email + "' is already registered in the system.", cause);
    }
}


