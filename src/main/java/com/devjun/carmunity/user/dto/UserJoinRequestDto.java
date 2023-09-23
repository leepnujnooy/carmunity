package com.devjun.carmunity.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserJoinRequestDto {

    private String email;
    private String password;
    private String passwordCheck;
    private String nickname;

}
