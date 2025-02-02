package com.natixis.EasyPay.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SchedulingSummaryDto {

    private Long clientId;
    private LocalDate scheduleDate;
    private BigDecimal finalValue;

    public SchedulingSummaryDto() {
    }

    public SchedulingSummaryDto(Long clientId, LocalDate scheduleDate, BigDecimal finalValue) {
        this.clientId = clientId;
        this.scheduleDate = scheduleDate;
        this.finalValue = finalValue;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public BigDecimal getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(BigDecimal finalValue) {
        this.finalValue = finalValue;
    }
}
