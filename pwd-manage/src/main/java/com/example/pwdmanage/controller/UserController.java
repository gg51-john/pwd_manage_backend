package com.example.pwdmanage.controller;

import com.example.pwdmanage.entity.ThirdPartyUser;
import com.example.pwdmanage.model.ThirdPartyLoginRequest;
import com.example.pwdmanage.model.ThirdPartyLoginResponse;
import com.example.pwdmanage.service.ThirdPartyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    ThirdPartyUserService thirdPartyUserService;
    @CrossOrigin("http://localhost:3000")
    @PostMapping
    @RequestMapping("/user/valid")
    public ThirdPartyLoginResponse validThirdPartyUser(@RequestBody ThirdPartyLoginRequest request) throws Exception {
        return thirdPartyUserService.validThirdPartyUser(request);
    }
}
