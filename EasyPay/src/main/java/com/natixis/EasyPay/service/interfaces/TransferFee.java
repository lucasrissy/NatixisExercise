package com.natixis.EasyPay.service.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransferFee {
    BigDecimal calculate(BigDecimal amount, LocalDate schedulingDate);
}
