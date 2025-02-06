package com.natixis.EasyPay.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseDto {

    private HttpStatus errorCode;

    private String errorMessage;

    private LocalDateTime errorTime;

    public ResponseDto() {
    }

    public ResponseDto(HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(LocalDateTime errorTime) {
        this.errorTime = errorTime;
    }
}
