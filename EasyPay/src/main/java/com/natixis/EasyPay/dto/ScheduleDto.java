package com.natixis.EasyPay.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ScheduleDto {

    private Long id;
    private Long clientId;
    private BigDecimal amount;
    private LocalDate scheduleDate;
    private BigDecimal finalValue;

    public ScheduleDto() {
    }

    public ScheduleDto(Long id, Long clientId, BigDecimal amount, LocalDate scheduleDate, BigDecimal finalValue) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.scheduleDate = scheduleDate;
        this.finalValue = finalValue;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public BigDecimal getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(BigDecimal finalValue) {
        this.finalValue = finalValue;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}
