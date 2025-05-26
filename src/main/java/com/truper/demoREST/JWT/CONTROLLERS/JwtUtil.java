package com.truper.demoREST.JWT.CONTROLLERS;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY ="clave123";
    private static final long EXPIRATION_TIME = 3600000;

    public String GenerateToken(String username){
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY.getBytes())
                .compact();

        return token;
    }

    public boolean isTokenValid(String token){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .parseClaimsJwt(token)
                    .getBody();
            return claims.getExpiration().after(new Date());
        }catch(Exception ex){
            return  false;
        }
    }

}
