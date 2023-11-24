package com.example.pwdmanage.service;

import com.example.pwdmanage.entity.ThirdPartyUser;
import com.example.pwdmanage.model.ThirdPartyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserDetailsServiceImpl {

//    @Autowired
//    private ThirdPartyUserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        ThirdPartyUser user = null;
//        try {
//            user = userService.find(username);
//        } catch (ExecutionException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
////        if (user == null) {
////            throw new UsernameNotFoundException("Can't find user: " + username);
////        }
//
//        return new ThirdPartyUserDetails(user);
//    }


}
