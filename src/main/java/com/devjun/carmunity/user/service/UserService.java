package com.devjun.carmunity.user.service;

import com.devjun.carmunity.global.exception.CustomException;
import com.devjun.carmunity.global.exception.ErrorCode;
import com.devjun.carmunity.user.dto.UserJoinRequestDto;
import com.devjun.carmunity.user.entity.User;
import com.devjun.carmunity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    //login

    //join
    public void join(UserJoinRequestDto requestDto){
        //계정 중복 예외처리
        User user =userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(()->new CustomException(ErrorCode.DUPLICATED_USER_NAME,ErrorCode.DUPLICATED_USER_NAME.getMessage()));

        userRepository.save(
                User
                        .builder()
                        .email(requestDto.getEmail())
                        .password(passwordEncoder.encode(requestDto.getPassword()))
                        .nickname(requestDto.getNickname())
                        .build());

    }

    //profile change

    //password change

}
