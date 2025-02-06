package com.natixis.EasyPay.service.factory;

import com.natixis.EasyPay.service.interfaces.ScheduleValidator;
import com.natixis.EasyPay.service.interfaces.validators.FeeAValidator;
import com.natixis.EasyPay.service.interfaces.validators.FeeBValidator;
import com.natixis.EasyPay.service.interfaces.validators.FeeCValidator;

import java.math.BigDecimal;

public class ScheduleValidatorFactory {

    public static ScheduleValidator getValidator(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(1000)) <= 0) {
            System.out.println(amount);
            System.out.println("não e aqui");
            return new FeeAValidator();
        } else if (amount.compareTo(BigDecimal.valueOf(1001)) >= 0 && amount.compareTo(BigDecimal.valueOf(2000)) <= 0 ){
            return new FeeBValidator();
        } else {
            return new FeeCValidator();
        }
    }
}
