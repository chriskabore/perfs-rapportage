package com.kirasoft.perfs.users.exceptions;

public class InvalidUserIdentifierException extends RuntimeException{

    public InvalidUserIdentifierException(String message){
        super(message);
    }
}
