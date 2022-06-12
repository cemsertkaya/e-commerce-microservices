package com.archTech.userservice.controller;

import com.archTech.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.archTech.userservice.entity.User;
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController
{

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of userController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserWithId(@PathVariable("id") Long userId)
    {
        log.info("Inside getUserWithDepartment of UserController");
        return  userService.findUserById(userId);
    }


    @DeleteMapping("/delete")
    public void deleteAllUsers()
    {
        userService.deleteAllUsers();
    }
}
