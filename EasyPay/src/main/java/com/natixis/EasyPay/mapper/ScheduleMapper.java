package com.natixis.EasyPay.mapper;

import com.natixis.EasyPay.dto.ScheduleDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.entity.ScheduleEntity;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    public static ScheduleEntity mapToEntity (ScheduleEntity entity, ScheduleDto dto){

        entity.setFinalValue(dto.getFinalValue());
       // entity.setId(dto.getId());
        entity.setScheduleDate(dto.getScheduleDate());
        entity.setAmount(dto.getAmount());
        entity.setClientId(dto.getClientId());

        return entity;
    }

    public static ScheduleDto mapToDto (ScheduleEntity entity, ScheduleDto dto){

        dto.setFinalValue(entity.getFinalValue());
       // dto.setId(entity.getId());
        dto.setScheduleDate(entity.getScheduleDate());
        dto.setAmount(entity.getAmount());
        dto.setClientId(entity.getClientId());

        return dto;
    }

    public static ScheduleEntity mapToEntity (ScheduleEntity entity, SchedulingSummaryDto dto){

        entity.setFinalValue(dto.getFinalValue());
        entity.setScheduleDate(dto.getScheduleDate());
        entity.setClientId(dto.getClientId());

        return entity;
    }

    public static SchedulingSummaryDto mapToDto (ScheduleEntity entity, SchedulingSummaryDto dto){

        dto.setFinalValue(entity.getFinalValue());
        dto.setScheduleDate(entity.getScheduleDate());
        dto.setClientId(entity.getClientId());

        return dto;
    }
}
