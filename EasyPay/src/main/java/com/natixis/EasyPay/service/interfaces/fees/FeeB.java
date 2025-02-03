package com.natixis.EasyPay.service.interfaces.fees;

import com.natixis.EasyPay.service.interfaces.TransferFee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FeeB implements TransferFee {

    /**
     * @param amount
     * @param schedulingDate
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal amount, LocalDate schedulingDate) {
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), schedulingDate);
        if (daysBetween >= 1 && daysBetween <= 10) {
            return amount.multiply(BigDecimal.valueOf(0.09)).add(amount).setScale(2, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}
