package com.natixis.EasyPay.service;

import com.natixis.EasyPay.entity.SchedulingEntity;
import com.natixis.EasyPay.repository.TransactionRepository;
import com.natixis.EasyPay.service.factory.FeeFactory;
import com.natixis.EasyPay.service.interfaces.TransferFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public SchedulingEntity calculateTransactionFee(SchedulingEntity entity) {
        TransferFee fee = FeeFactory.getFeeStrategy(entity.getAmount(), entity.getScheduleDate());
        entity.setFinalValue(fee.calculate(entity.getAmount(), entity.getScheduleDate()));
        repository.save(entity);
        return entity;
    }
}
