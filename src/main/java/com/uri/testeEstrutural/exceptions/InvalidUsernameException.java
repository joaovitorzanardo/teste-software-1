package com.uri.testeEstrutural.exceptions;

public class InvalidUsernameException extends RuntimeException{
    public InvalidUsernameException() {
        super("O username deve ter de 5 a 8 caracteres sendo eles apenas letras e números.");
    }
}
