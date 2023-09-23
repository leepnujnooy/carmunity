package com.devjun.carmunity.global.jwt;


import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.security.Key;

@Configuration
@Slf4j
public class JwtUtils {

    private Key signKey;
    private JwtParser jwtParser;

    public JwtUtils(@Value("${jwt.secret}") String secret){
        this.signKey = Keys.hmacShaKeyFor(secret.getBytes());
        this.jwtParser = Jwts.parserBuilder().setSigningKey(signKey).build();
    }



}
