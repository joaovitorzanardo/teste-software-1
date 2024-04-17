package com.uri.testeEstrutural.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String username) {
        super("O username " + username + " já existe!");
    }
}
