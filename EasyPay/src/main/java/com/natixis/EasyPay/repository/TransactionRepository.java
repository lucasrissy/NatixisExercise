package com.natixis.EasyPay.repository;

import com.natixis.EasyPay.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<ScheduleEntity, Long> {
}
