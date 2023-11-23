package com.example.pwdmanage.controller;

import com.example.pwdmanage.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @RequestMapping("/user/login")
    public void Login(@RequestBody User user){

    }
}
