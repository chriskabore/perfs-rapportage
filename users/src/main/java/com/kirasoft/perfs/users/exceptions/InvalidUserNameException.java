package com.kirasoft.perfs.users.exceptions;

public class InvalidUserNameException extends RuntimeException{

    public InvalidUserNameException(String message){
        super(message);
    }
}
