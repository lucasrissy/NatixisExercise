package com.natixis.EasyPay.service.interfaces.validators;

import com.natixis.EasyPay.service.interfaces.ScheduleValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FeeCValidator implements ScheduleValidator {
    /**
     * @param newDate
     * @param amount
     */
    @Override
    public void validate(LocalDate newDate, BigDecimal amount) {
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), newDate);

        if (daysBetween >= 11 && daysBetween <= 20) {
            // Data válida
        } else if (daysBetween >= 21 && daysBetween <= 30) {
            // Data válida
        } else if (daysBetween >= 31 && daysBetween <= 40) {
            // Data válida
        } else if (daysBetween > 40) {
            // Data válida
        } else {
            throw new IllegalArgumentException("Para montantes maiores que 2000€, a data deve estar entre 11 e mais de 40 dias.");
        }
    }
}
