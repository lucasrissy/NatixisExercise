package com.natixis.EasyPay.exception;

public class SchedulingNotFoundException extends RuntimeException{

    private Long id;

    public SchedulingNotFoundException(Long id){
        super(String.format("Scheduling with ID '%d' was not found", id));
        this.id = id;
    }
}
