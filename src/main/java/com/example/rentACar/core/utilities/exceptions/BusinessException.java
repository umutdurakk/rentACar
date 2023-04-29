package com.example.rentACar.core.utilities.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String err){
        super(err);
    }
}
