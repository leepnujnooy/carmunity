package com.devjun.carmunity.user.entity;

import com.devjun.carmunity.user.car.CarType;
import com.devjun.carmunity.user.level.UserLevel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    // 아이디 ( 이메일 형식 )
    // 비밀번호
    // 차종 ( ENUM )
    // 레벨 ( ENUM )
    // 리뷰
    // 댓글

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column
    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;

    @Builder
    public User(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }



}
