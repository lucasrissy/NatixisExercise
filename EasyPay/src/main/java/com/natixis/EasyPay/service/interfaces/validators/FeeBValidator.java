package com.natixis.EasyPay.service.interfaces.validators;

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
            throw new IllegalArgumentException("Para montantes entre 1001€ e 2000€, a data deve estar entre 1 e 10 dias.");
        }

    }
}
