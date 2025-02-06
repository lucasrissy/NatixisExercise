package com.natixis.EasyPay.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_scheduling")
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private BigDecimal amount;
    private LocalDate scheduleDate;
    private BigDecimal finalValue;

    public ScheduleEntity() {
    }

    public ScheduleEntity(Long id, Long clientId, BigDecimal amount, LocalDate scheduleDate, BigDecimal finalValue) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.scheduleDate = scheduleDate;
        this.finalValue = finalValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
