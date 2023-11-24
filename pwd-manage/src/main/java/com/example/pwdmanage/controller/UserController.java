package com.example.pwdmanage.controller;

import com.example.pwdmanage.entity.ThirdPartyUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @PostMapping
    @RequestMapping("/user/login")
    public void Login(@RequestBody ThirdPartyUser user) {

    }
}
