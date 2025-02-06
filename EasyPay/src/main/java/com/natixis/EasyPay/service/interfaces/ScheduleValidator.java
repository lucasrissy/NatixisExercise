package com.natixis.EasyPay.service.interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ScheduleValidator {
    void validate(LocalDate newDate, BigDecimal amount);
}
