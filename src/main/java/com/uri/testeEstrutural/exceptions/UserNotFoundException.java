package com.uri.testeEstrutural.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("O usuário " + username + " não existe!");
    }
}
