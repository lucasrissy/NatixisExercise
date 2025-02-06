package com.natixis.EasyPay.dto;

import java.time.LocalDate;

public class ScheduleUpdateDto {
    private LocalDate scheduleDate;

    public ScheduleUpdateDto() {
    }

    public ScheduleUpdateDto(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
