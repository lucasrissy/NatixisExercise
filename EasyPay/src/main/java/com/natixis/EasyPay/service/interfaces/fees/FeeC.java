package com.natixis.EasyPay.service.interfaces.fees;

import com.natixis.EasyPay.service.interfaces.TransferFee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FeeC implements TransferFee {
    /**
     * @param amount
     * @param schedulingDate
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal amount, LocalDate schedulingDate) {

        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), schedulingDate);

        if (daysBetween >= 11 && daysBetween <= 20) {
            return amount.multiply(BigDecimal.valueOf(0.082));
        } else if (daysBetween >= 21 && daysBetween <= 30) {
            return amount.multiply(BigDecimal.valueOf(0.069));
        } else if (daysBetween >= 31 && daysBetween <= 40) {
            return amount.multiply(BigDecimal.valueOf(0.047));
        } else if (daysBetween > 40) {
            return amount.multiply(BigDecimal.valueOf(0.017));
        }

        return BigDecimal.ZERO;
    }
}
