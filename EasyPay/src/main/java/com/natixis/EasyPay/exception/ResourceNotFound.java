package com.natixis.EasyPay.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with the given input data %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
