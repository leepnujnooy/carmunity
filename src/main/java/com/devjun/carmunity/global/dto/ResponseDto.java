package com.devjun.carmunity.global.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto {
    private String message;
    private HttpStatus httpStatus;
}
