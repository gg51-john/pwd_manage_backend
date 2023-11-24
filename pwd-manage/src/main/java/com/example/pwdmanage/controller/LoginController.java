package com.example.pwdmanage.controller;

import com.example.pwdmanage.model.ThirdPartyLoginRequest;
import com.example.pwdmanage.model.ThirdPartyLoginResponse;
import com.example.pwdmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    @RequestMapping("/login")
    public ThirdPartyLoginResponse thirdPartyLogin(@RequestBody ThirdPartyLoginRequest request) throws Exception {
        return loginService.ThirdPartyLogin(request);
    }
}
