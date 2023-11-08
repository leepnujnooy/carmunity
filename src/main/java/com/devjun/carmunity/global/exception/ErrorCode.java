package com.devjun.carmunity.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "user name is duplicated"),
    DIFF_PASSWORD_CHECK(HttpStatus.BAD_REQUEST, "password check is different with password"),
    PAGE_NUMBER_OUT_OF_BOUNDS(HttpStatus.BAD_REQUEST, "page number is wrong"),
    USER_NAME_NOT_FOUND(HttpStatus.BAD_REQUEST,"user name is not found"),
    PASSWORD_INCORRECT(HttpStatus.BAD_REQUEST,"password is not correct");

    private HttpStatus status;
    private String message;
}
