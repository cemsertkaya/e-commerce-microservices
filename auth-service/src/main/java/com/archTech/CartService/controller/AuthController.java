package com.archTech.CartService.controller;
import com.archTech.CartService.entity.AuthSignUp;
import com.archTech.CartService.entity.User;
import com.archTech.CartService.entity.AuthLogin;
import com.archTech.CartService.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
@Slf4j
public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public User signUp(@RequestBody AuthSignUp auth) {return (User) authService.signUp(auth);}

    @PostMapping("/")
    public User logIn(@RequestBody AuthLogin auth) {return (User) authService.login(auth);}

}
