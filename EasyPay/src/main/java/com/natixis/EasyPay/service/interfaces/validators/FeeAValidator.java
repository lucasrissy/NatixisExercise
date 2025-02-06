package com.natixis.EasyPay.service.interfaces.validators;

import com.natixis.EasyPay.exception.InvalidDateException;
import com.natixis.EasyPay.service.interfaces.ScheduleValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FeeAValidator implements ScheduleValidator {
    /**
     * @param newDate
     * @param amount
     */
    @Override
    public void validate(LocalDate newDate, BigDecimal amount) {

        LocalDate currentDate = LocalDate.now();
        if (!newDate.isEqual(currentDate)) {
            throw new InvalidDateException(newDate.toString(), "0 days from today");
        }

    }
}
