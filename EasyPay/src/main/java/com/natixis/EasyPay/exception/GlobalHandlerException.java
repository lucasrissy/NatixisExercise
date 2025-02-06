package com.natixis.EasyPay.exception;

import com.natixis.EasyPay.dto.ResponseErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<ResponseErrorDto> handleInvalidDateException (InvalidDateException exception){

        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseErrorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SchedulingNotFoundException.class)
    public ResponseEntity<ResponseErrorDto> handleSchedulingNotFoundException (SchedulingNotFoundException exception){

        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseErrorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessRuleViolationException.class)
    public ResponseEntity<ResponseErrorDto> handleBusinessRuleViolationException (BusinessRuleViolationException exception, WebRequest webRequest){

        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseErrorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseErrorDto> handleResourceNotFoundException (ResourceNotFound exception, WebRequest webRequest){

        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseErrorDto, HttpStatus.BAD_REQUEST);
    }



}
