package com.natixis.EasyPay.repository;

import com.natixis.EasyPay.entity.SchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<SchedulingEntity, Long> {
}
