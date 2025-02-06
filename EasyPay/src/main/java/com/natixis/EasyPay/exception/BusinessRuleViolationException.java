package com.natixis.EasyPay.exception;

import java.math.BigDecimal;

public class BusinessRuleViolationException extends RuntimeException{

    public BusinessRuleViolationException(BigDecimal amount) {
        super(generateMessage(amount));
    }

    private static String generateMessage(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(1000)) <= 0) {
            return "For amounts up to 1000€, only scheduling for today's date is allowed.";
        } else if (amount.compareTo(BigDecimal.valueOf(2000)) <= 0) {
            return "For amounts between 1001€ and 2000€, scheduling is only allowed within 10 days from today.";
        } else {
            return "For amounts above 2000€, scheduling is only allowed starting from 11 days up to 40 days from today.";
        }
    }
}
