package com.natixis.EasyPay.controller;

import com.natixis.EasyPay.dto.ScheduleUpdateDto;
import com.natixis.EasyPay.dto.SchedulingDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<ScheduleUpdateDto> update(@RequestBody ScheduleUpdateDto dto, @PathVariable Long id){

        /*
        if(service.updateSensor(dto,id)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(HttpStatus.OK,"Update was realized!"));
        }else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(HttpStatus.EXPECTATION_FAILED,"update was not realized!"));
        }
        */
        return ResponseEntity.ok(service.updateSchedule(id,dto));
    }

    @DeleteMapping("/update/{id}") void deleteSchedule(@PathVariable Long id){
        boolean isDeleted = service.deleteScheduleById(id);
    }
}
