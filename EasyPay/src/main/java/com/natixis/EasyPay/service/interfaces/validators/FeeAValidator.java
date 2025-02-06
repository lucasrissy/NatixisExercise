package com.natixis.EasyPay.service.interfaces.validators;

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
            throw new IllegalArgumentException("Para montantes até 1000€, a data deve ser igual à atual.");
        }

    }
}
