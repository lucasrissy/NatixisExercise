package com.natixis.EasyPay.service;

import com.natixis.EasyPay.dto.SchedulingDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.entity.SchedulingEntity;
import com.natixis.EasyPay.mapper.SchedulingMapper;
import com.natixis.EasyPay.repository.TransactionRepository;
import com.natixis.EasyPay.service.factory.FeeFactory;
import com.natixis.EasyPay.service.interfaces.TransferFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    
    public SchedulingDto getShedulingById(Long id){
        return SchedulingMapper.mapToDto(repository.findById(id).get(),new SchedulingDto());
    }

    public List<SchedulingSummaryDto> getAllScheduling(){
        return repository.findAll().stream().map(e -> SchedulingMapper.mapToDto(e,new SchedulingSummaryDto())).toList();
    }
}
