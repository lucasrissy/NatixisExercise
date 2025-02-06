package com.natixis.EasyPay.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseDto {
    private HttpStatus code;

    private String message;

    private LocalDateTime time;

    public ResponseDto() {
    }

    public ResponseDto(HttpStatus code, String message, LocalDateTime time) {
        this.code = code;
        this.message = message;
        this.time = time;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
