package com.natixis.EasyPay.exception;

import com.natixis.EasyPay.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<ResponseDto> handleInvalidDateException (InvalidDateException exception){

        ResponseDto responseDto = new ResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SchedulingNotFoundException.class)
    public ResponseEntity<ResponseDto> handleSchedulingNotFoundException (SchedulingNotFoundException exception){

        ResponseDto responseDto = new ResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessRuleViolationException.class)
    public ResponseEntity<ResponseDto> handleBusinessRuleViolationException (BusinessRuleViolationException exception, WebRequest webRequest){

        ResponseDto responseDto = new ResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseDto> handleResourceNotFoundException (ResourceNotFound exception, WebRequest webRequest){

        ResponseDto responseDto = new ResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
