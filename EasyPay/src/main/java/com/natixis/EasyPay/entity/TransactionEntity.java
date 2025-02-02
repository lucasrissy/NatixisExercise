package com.natixis.EasyPay.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TransactionEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private BigDecimal amount;
    private Date scheduleDate;
    private BigDecimal fee;
}
