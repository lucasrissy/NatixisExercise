package com.natixis.EasyPay.service.interfaces.fees;

import com.natixis.EasyPay.service.interfaces.TransferFee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class FeeA implements TransferFee {

    /**
     * @param amount
     * @param schedulingDate
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal amount, LocalDate schedulingDate) {
        return amount.multiply(new BigDecimal("0.03")).add(BigDecimal.valueOf(3)).add(amount).setScale(2, RoundingMode.HALF_UP);
    }


}
