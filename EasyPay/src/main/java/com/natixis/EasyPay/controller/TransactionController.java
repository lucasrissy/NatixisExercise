package com.natixis.EasyPay.controller;

import com.natixis.EasyPay.entity.SchedulingEntity;
import com.natixis.EasyPay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingEntity> getAmountById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getShedulingById(id));
    }
}
