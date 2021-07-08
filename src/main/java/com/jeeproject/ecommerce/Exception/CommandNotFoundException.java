package com.jeeproject.ecommerce.Exception;

public class CommandNotFoundException extends RuntimeException{

    public CommandNotFoundException(String message) {
        super(message);
    }
}
