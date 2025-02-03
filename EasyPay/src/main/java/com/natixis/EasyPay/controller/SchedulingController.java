package com.natixis.EasyPay.controller;

import com.natixis.EasyPay.dto.SchedulingDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/")
public class SchedulingController {

    @Autowired
    private SchedulingService service;

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingDto> getSchedulingDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSchedulingById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SchedulingSummaryDto>> getAllScheduling() {
        return ResponseEntity.ok(service.getAllScheduling());
    }

    @PostMapping("/create")
    public ResponseEntity<SchedulingDto> createScheduling(@RequestBody SchedulingDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createScheduling(dto));
    }
}
