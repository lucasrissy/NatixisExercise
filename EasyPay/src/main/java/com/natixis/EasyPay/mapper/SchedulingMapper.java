package com.natixis.EasyPay.mapper;

import com.natixis.EasyPay.dto.SchedulingDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.entity.SchedulingEntity;
import org.springframework.stereotype.Component;

@Component
public class SchedulingMapper {

    public static SchedulingEntity mapToEntity (SchedulingEntity entity, SchedulingDto dto){

        entity.setFinalValue(dto.getFinalValue());
       // entity.setId(dto.getId());
        entity.setScheduleDate(dto.getScheduleDate());
        entity.setAmount(dto.getAmount());
        entity.setClientId(dto.getClientId());

        return entity;
    }

    public static SchedulingDto mapToDto (SchedulingEntity entity, SchedulingDto dto){

        dto.setFinalValue(entity.getFinalValue());
       // dto.setId(entity.getId());
        dto.setScheduleDate(entity.getScheduleDate());
        dto.setAmount(entity.getAmount());
        dto.setClientId(entity.getClientId());

        return dto;
    }

    public static SchedulingEntity mapToEntity (SchedulingEntity entity, SchedulingSummaryDto dto){

        entity.setFinalValue(dto.getFinalValue());
        entity.setScheduleDate(dto.getScheduleDate());
        entity.setClientId(dto.getClientId());

        return entity;
    }

    public static SchedulingSummaryDto mapToDto (SchedulingEntity entity, SchedulingSummaryDto dto){

        dto.setFinalValue(entity.getFinalValue());
        dto.setScheduleDate(entity.getScheduleDate());
        dto.setClientId(entity.getClientId());

        return dto;
    }
}
