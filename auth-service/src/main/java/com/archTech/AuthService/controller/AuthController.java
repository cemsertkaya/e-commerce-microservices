package com.archTech.AuthService.controller;

import com.archTech.AuthService.VO.User;
import com.archTech.AuthService.service.AuthService;
import com.archTech.AuthService.entity.AuthSignUp;
import com.archTech.AuthService.entity.AuthLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User signUp(@RequestBody AuthSignUp auth) {
        return (User) authService.signUp(auth);
    }

    @PostMapping(value = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User logIn(@RequestBody AuthLogin auth) {
        return (User) authService.login(auth);
    }

}
