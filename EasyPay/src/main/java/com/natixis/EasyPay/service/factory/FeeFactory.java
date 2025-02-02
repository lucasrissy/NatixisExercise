package com.natixis.EasyPay.service.factory;

import com.natixis.EasyPay.service.interfaces.TransferFee;
import com.natixis.EasyPay.service.interfaces.fees.FeeA;
import com.natixis.EasyPay.service.interfaces.fees.FeeB;
import com.natixis.EasyPay.service.interfaces.fees.FeeC;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FeeFactory {

    public static TransferFee getFeeStrategy(BigDecimal amount, LocalDate schedulingDate) {

        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), schedulingDate);

        if (amount.compareTo(BigDecimal.valueOf(1000)) <= 0 && daysBetween == 0) {
            return new FeeA();
        } else if (amount.compareTo(BigDecimal.valueOf(1001)) >= 0 && amount.compareTo(BigDecimal.valueOf(2000)) <= 0 && daysBetween >= 1 && daysBetween <= 10) {
            return new FeeB();
        } else if (amount.compareTo(BigDecimal.valueOf(2000)) > 0) {
            return new FeeC();
        }

        throw new IllegalArgumentException("No valid fee type found for the given transaction.");
    }
}
