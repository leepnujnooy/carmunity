package com.devjun.carmunity.user.controller;

import com.devjun.carmunity.global.dto.ResponseDto;
import com.devjun.carmunity.global.exception.CustomException;
import com.devjun.carmunity.global.exception.ErrorCode;
import com.devjun.carmunity.user.dto.UserJoinRequestDto;
import com.devjun.carmunity.user.dto.UserLoginRequestDto;
import com.devjun.carmunity.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;


    //로그인
    @PostMapping("/login")
    public ResponseDto login(HttpServletResponse response, UserLoginRequestDto requestDto){




        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("login success");
        responseDto.setHttpStatus(HttpStatus.OK);

        return responseDto;
    }


    //회원가입
    @PostMapping("/join")
    public ResponseDto join(UserJoinRequestDto requestDto){
        //체크 패스워드 다를 시 예외처리
        if(!requestDto.getPassword().equals(requestDto.getPasswordCheck())){
            throw new CustomException(ErrorCode.DIFF_PASSWORD_CHECK,ErrorCode.DIFF_PASSWORD_CHECK.getMessage());
        }

        //유저 서비스로 이동
        userService.join(requestDto);


        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("join success");
        responseDto.setHttpStatus(HttpStatus.OK);
        return responseDto;

    }



    //비밀번호 수정
    //프로필사진 수정





}
