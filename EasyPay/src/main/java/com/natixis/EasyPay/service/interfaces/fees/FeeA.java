package com.natixis.EasyPay.service.interfaces.fees;

import com.natixis.EasyPay.service.interfaces.TransferFee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FeeA implements TransferFee {

    /**
     * @param amount
     * @param schedulingDate
     * @return
     */
    @Override
    public BigDecimal calculate(BigDecimal amount, LocalDate schedulingDate) {
        return amount.multiply(BigDecimal.valueOf(0.03)).add(BigDecimal.valueOf(3));
    }


}
