package com.natixis.EasyPay.service;

import com.natixis.EasyPay.dto.ScheduleUpdateDto;
import com.natixis.EasyPay.dto.SchedulingDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.entity.SchedulingEntity;
import com.natixis.EasyPay.mapper.SchedulingMapper;
import com.natixis.EasyPay.repository.TransactionRepository;
import com.natixis.EasyPay.service.factory.FeeFactory;
import com.natixis.EasyPay.service.factory.ScheduleValidatorFactory;
import com.natixis.EasyPay.service.interfaces.ScheduleValidator;
import com.natixis.EasyPay.service.interfaces.TransferFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private TransactionRepository repository;

    public TransferFee getFee(SchedulingDto dto) {
        TransferFee fee = FeeFactory.getFeeStrategy(dto.getAmount(), dto.getScheduleDate());
        return fee;
    }
    
    public SchedulingDto getSchedulingById(Long id){
        return SchedulingMapper.mapToDto(repository.findById(id).get(),new SchedulingDto());
    }

    public List<SchedulingSummaryDto> getAllScheduling(){
        return repository.findAll().stream().map(e -> SchedulingMapper.mapToDto(e,new SchedulingSummaryDto())).toList();
    }

    public SchedulingDto createScheduling(SchedulingDto dto){
        TransferFee fee = getFee(dto);
        BigDecimal finalValue = fee.calculate(dto.getAmount(), dto.getScheduleDate());
        dto.setFinalValue(finalValue);
        repository.save(SchedulingMapper.mapToEntity(new SchedulingEntity(),dto));
        return dto;
    }

    public ScheduleUpdateDto updateSchedule(Long id, ScheduleUpdateDto dto){
        SchedulingEntity entity = repository.getReferenceById(id);

        ScheduleValidator validator = ScheduleValidatorFactory.getValidator(entity.getAmount());

        validator.validate(dto.getScheduleDate(), entity.getAmount());

        entity.setScheduleDate(dto.getScheduleDate());

        repository.save(entity);

        return dto;
    }

    public boolean deleteScheduleById(Long id){
        boolean isUpdate = false;

        if (repository.existsById(id)){

            repository.deleteById(id);

            isUpdate = true;
        }
        return isUpdate;
    }
}
