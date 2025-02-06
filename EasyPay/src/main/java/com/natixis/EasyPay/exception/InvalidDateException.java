package com.natixis.EasyPay.exception;

public class InvalidDateException extends RuntimeException{

    private final String providedDate;
    private final String allowedRange;

    public InvalidDateException(String providedDate, String allowedRange) {
        super(String.format("Invalid date '%s'. Allowed range: %s", providedDate, allowedRange));
        this.providedDate = providedDate;
        this.allowedRange = allowedRange;
    }

    public String getProvidedDate() {
        return providedDate;
    }

    public String getAllowedRange() {
        return allowedRange;
    }

}
