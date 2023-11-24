package com.example.pwdmanage.service;

import com.example.pwdmanage.entity.ThirdPartyUser;
import com.example.pwdmanage.model.ThirdPartyLoginRequest;
import com.example.pwdmanage.model.ThirdPartyLoginResponse;
import com.example.pwdmanage.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    ThirdPartyUserService userService;

    public ThirdPartyLoginResponse ThirdPartyLogin(ThirdPartyLoginRequest request) throws Exception {
        ThirdPartyLoginResponse response = new ThirdPartyLoginResponse();
        //查詢
        ThirdPartyUser thirdPartyUser = userService.find(request.getThirdPartyUserEmail());
        if (thirdPartyUser == null) {
            //無資料新增
            thirdPartyUser = new ThirdPartyUser();
            thirdPartyUser.setId(request.getThirdPartyUserId());
            thirdPartyUser.setProvider(request.getProvider());
            thirdPartyUser.setThirdPartyUserId(request.getThirdPartyUserId());
            thirdPartyUser.setThirdPartyUserEmail(request.getThirdPartyUserEmail());
            thirdPartyUser.setMainKey(request.getMainKey());
            thirdPartyUser.setRegistrationTime(ToolService.DateFormat());
            //設定token
            thirdPartyUser.setToken(JwtUtil.createToken(request.getThirdPartyUserId(), request.getThirdPartyUserEmail()));

            //返回
            String timeStamp = userService.insert(thirdPartyUser);
            if (timeStamp != null) {
                response.setId(request.getThirdPartyUserId());
                response.setToken(thirdPartyUser.getToken());
                return response;
            }
            throw new Exception("Internal Error!!");
        }
        //有資料更新(token、LoginTime)
        thirdPartyUser.setToken(JwtUtil.createToken(thirdPartyUser.getThirdPartyUserId(), thirdPartyUser.getThirdPartyUserEmail()));
        if (userService.update(thirdPartyUser)) {
            response.setId(thirdPartyUser.getId());
            response.setToken(thirdPartyUser.getToken());
            return response;
        }
        throw new Exception("Internal Error!!");
    }
}
