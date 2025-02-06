package com.natixis.EasyPay.controller;

import com.natixis.EasyPay.dto.ResponseDto;
import com.natixis.EasyPay.dto.ScheduleUpdateDto;
import com.natixis.EasyPay.dto.ScheduleDto;
import com.natixis.EasyPay.dto.SchedulingSummaryDto;
import com.natixis.EasyPay.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/")
public class SchedulingController {

    @Autowired
    private ScheduleService service;

    @GetMapping("get/{id}")
    public ResponseEntity<ScheduleDto> getSchedulingDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSchedulingById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SchedulingSummaryDto>> getAllScheduling() {
        return ResponseEntity.ok(service.getAllScheduling());
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createScheduling(@RequestBody ScheduleDto dto){


        service.createScheduling(dto);

        ResponseDto response = new ResponseDto(
                HttpStatus.CREATED,
                "Scheduling created successfully!",
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ScheduleUpdateDto> update(@RequestBody ScheduleUpdateDto dto, @PathVariable Long id){


        return ResponseEntity.ok(service.updateSchedule(id,dto));
    }

    @DeleteMapping("/delete/{id}") ResponseEntity<ResponseDto> deleteSchedule(@PathVariable Long id){
        boolean isDeleted = service.deleteScheduleById(id);
        if (isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(
                     new ResponseDto(
                            HttpStatus.OK,
                            "Scheduling deleted successfully!",
                            LocalDateTime.now()
                    )
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseDto(
                        HttpStatus.NOT_FOUND,
                        "Scheduling not found!",
                        LocalDateTime.now()
                )
        );
    }
}
