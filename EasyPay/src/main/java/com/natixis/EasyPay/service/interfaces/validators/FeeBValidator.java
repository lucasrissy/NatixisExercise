package com.natixis.EasyPay.service.interfaces.validators;

import com.natixis.EasyPay.exception.InvalidDateException;
import com.natixis.EasyPay.service.interfaces.ScheduleValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FeeBValidator implements ScheduleValidator {
    /**
     * @param newDate
     * @param amount
     */
    @Override
    public void validate(LocalDate newDate, BigDecimal amount) {
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), newDate);
        if (daysBetween < 1 || daysBetween > 10) {
            throw new InvalidDateException(newDate.toString(), "1 to 10 days from today");
        }

    }
}
