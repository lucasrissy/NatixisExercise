package com.natixis.EasyPay.service;

import com.natixis.EasyPay.dto.ScheduleUpdateDto;
import com.natixis.EasyPay.dto.ScheduleDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.entity.ScheduleEntity;
import com.natixis.EasyPay.exception.InvalidDateException;
import com.natixis.EasyPay.exception.ResourceNotFound;
import com.natixis.EasyPay.mapper.ScheduleMapper;
import com.natixis.EasyPay.repository.ScheduleRepository;
import com.natixis.EasyPay.service.factory.FeeFactory;
import com.natixis.EasyPay.service.factory.ScheduleValidatorFactory;
import com.natixis.EasyPay.service.interfaces.ScheduleValidator;
import com.natixis.EasyPay.service.interfaces.TransferFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public TransferFee getFee(ScheduleDto dto) {
        TransferFee fee = FeeFactory.getFeeStrategy(dto.getAmount(), dto.getScheduleDate());
        return fee;
    }
    
    public ScheduleDto getSchedulingById(Long id){
        return ScheduleMapper.mapToDto(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Resource not found","id",id.toString())),new ScheduleDto());
    }

    public List<SchedulingSummaryDto> getAllScheduling(){
        return repository.findAll().stream().map(e -> ScheduleMapper.mapToDto(e,new SchedulingSummaryDto())).toList();
    }

    public ScheduleDto createScheduling(ScheduleDto dto){

        if (dto.getAmount() == null) {
            throw new IllegalArgumentException("Invalid amount");
        }

        if (dto.getScheduleDate() == null) {
            throw new IllegalArgumentException("Invalid schedule date");
        }
        TransferFee fee = getFee(dto);
        BigDecimal finalValue = fee.calculate(dto.getAmount(), dto.getScheduleDate());
        dto.setFinalValue(finalValue);
        repository.save(ScheduleMapper.mapToEntity(new ScheduleEntity(),dto));
        return dto;
    }

    public ScheduleUpdateDto updateSchedule(Long id, ScheduleUpdateDto dto){
        ScheduleEntity entity = repository.getReferenceById(id);

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
