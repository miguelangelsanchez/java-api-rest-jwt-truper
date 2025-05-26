package com.truper.demoREST.JWT.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public String login(@RequestParam String user, @RequestParam String password){

        return ("admin".equals(user)&& "1234".equals(password))
        ?jwtUtil.GenerateToken(user)
        :"Credenciales invalidas"
        ;
    }
}
