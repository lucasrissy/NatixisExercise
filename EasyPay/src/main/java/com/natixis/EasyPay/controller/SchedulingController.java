package com.natixis.EasyPay.controller;

import com.natixis.EasyPay.dto.*;
import com.natixis.EasyPay.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "EasyBank REST API",
        description = "A REST API providing endpoints to calculate final values and schedule date of the transaction"
)

@RestController
@RequestMapping("api/")
public class SchedulingController {

    @Autowired
    private ScheduleService service;


    @Operation(
            summary = "Get Schedule By Id",
            description = "REST API to obtain schedule based on a given index."

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved values.",
                    content = @Content(
                            mediaType = "4",
                            examples = {
                                    @ExampleObject(value = "[\n" +
                                            "  \"clientId\": \"103\",\n" +
                                            "  \"amount\": \"2500.00\",\n" +
                                            "  \"scheduleDate\": \"\"2025-03-05\"\"\n" +
                                            "  \"finalValue\": \"\"2655.00\"\"\n" +
                                            "]")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input provided.",
                    content = @Content(
                            mediaType = "-1",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"errorCode\": \"BAD_REQUEST\",\n" +
                                            "  \"errorMessage\": \"Resource not found not found with the given input data id :\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred while processing the request.",
                    content = @Content(
                            mediaType = "application/json.",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                            "  \"errorCode\": \"INTERNAL_SERVER_ERROR\",\n" +
                                            "  \"errorMessage\": \" An error occurred while processing the request\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            )
    })

    @GetMapping("get/{id}")
    public ResponseEntity<ScheduleDto> getSchedulingDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSchedulingById(id));
    }

    @Operation(
            summary = "Get All Schedule",
            description = "REST API to obtain All schedule"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved the values.",
                    content = @Content(
                            mediaType = "4",
                            examples = {
                                    @ExampleObject(value = "[\n" +
                                            "  \"clientId\": \"103\",\n" +
                                            "  \"amount\": \"2500.00\",\n" +
                                            "  \"scheduleDate\": \"\"2025-03-05\"\"\n" +
                                            "]")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred while processing the request.",
                    content = @Content(
                            mediaType = "application/json.",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                            "  \"errorCode\": \"INTERNAL_SERVER_ERROR\",\n" +
                                            "  \"errorMessage\": \" An error occurred while processing the request\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            )
    })

    @GetMapping("/getAll")
    public ResponseEntity<List<SchedulingSummaryDto>> getAllScheduling() {
        return ResponseEntity.ok(service.getAllScheduling());
    }

    @Operation(
            summary = "Create Schedule",
            description = "REST API to create schedule"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "create schedule Successfully .",
                    content = @Content(
                            mediaType = "SchedulingDto",
                            examples = {
                                    @ExampleObject(value = "[\n" +
                                            "  \"clientId\": \"103\",\n" +
                                            "  \"amount\": \"2500.00\",\n" +
                                            "  \"scheduleDate\": \"\"2025-03-05\"\"\n" +
                                            "]")
                            }
                    )
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred while processing the request.",
                    content = @Content(
                            mediaType = "application/json.",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                            "  \"errorCode\": \"INTERNAL_SERVER_ERROR\",\n" +
                                            "  \"errorMessage\": \" An error occurred while processing the request\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            )
    })
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

    @Operation(
            summary = "Update Schedule",
            description = "REST API to update schedule"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "update schedule Successfully .",
                    content = @Content(
                            mediaType = "SchedulingDto",
                            examples = {
                                    @ExampleObject(value = "[\n" +
                                            "  \"clientId\": \"103\",\n" +
                                            "  \"amount\": \"2500.00\",\n" +
                                            "  \"scheduleDate\": \"\"2025-03-05\"\"\n" +
                                            "]")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input provided.",
                    content = @Content(
                            mediaType = "-1",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"errorCode\": \"BAD_REQUEST\",\n" +
                                            "  \"errorMessage\": \"Resource not found not found with the given input data id :\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred while processing the request.",
                    content = @Content(
                            mediaType = "application/json.",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                            "  \"errorCode\": \"INTERNAL_SERVER_ERROR\",\n" +
                                            "  \"errorMessage\": \" An error occurred while processing the request\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            )
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<ScheduleUpdateDto> update(@RequestBody ScheduleUpdateDto dto, @PathVariable Long id){


        return ResponseEntity.ok(service.updateSchedule(id,dto));
    }


    @Operation(
            summary = "delete Schedule by id",
            description = "REST API to update schedule"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "delete schedule Successfully .",
                    content = @Content(
                            mediaType = "SchedulingDto",
                            examples = {
                                    @ExampleObject(value = "[\n" +
                                            "  \"clientId\": \"103\",\n" +
                                            "  \"amount\": \"2500.00\",\n" +
                                            "  \"scheduleDate\": \"\"2025-03-05\"\"\n" +
                                            "]")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input provided.",
                    content = @Content(
                            mediaType = "-1",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"errorCode\": \"BAD_REQUEST\",\n" +
                                            "  \"errorMessage\": \"Resource not found not found with the given input data id :\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An internal server error occurred while processing the request.",
                    content = @Content(
                            mediaType = "application/json.",
                            schema = @Schema(implementation = ResponseErrorDto.class),
                            examples = {
                                    @ExampleObject(value = "{\n" +
                                            "  \"apiPath\": \"uri=/labseq/-1\",\n" +
                                            "  \"errorCode\": \"INTERNAL_SERVER_ERROR\",\n" +
                                            "  \"errorMessage\": \" An error occurred while processing the request\",\n" +
                                            "  \"errorTime\": \"2024-12-11T19:02:31.5898166\"\n" +
                                            "}")
                            }
                    )
            )
    })
    @DeleteMapping("/delete/{id}") ResponseEntity<ResponseErrorDto> deleteSchedule(@PathVariable Long id){
        boolean isDeleted = service.deleteScheduleById(id);
        if (isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(
                     new ResponseErrorDto(
                            HttpStatus.OK,
                            "Scheduling deleted successfully!",
                            LocalDateTime.now()
                    )
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseErrorDto(
                        HttpStatus.NOT_FOUND,
                        "Scheduling not found!",
                        LocalDateTime.now()
                )
        );
    }
}
