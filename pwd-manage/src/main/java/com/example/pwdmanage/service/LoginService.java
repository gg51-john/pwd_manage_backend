package com.example.pwdmanage.service;

import com.example.pwdmanage.model.ThirdPartyUser;
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
        // 產生loginToken
        String loginToken = JwtUtil.createToken(request.getThirdPartyUserId(), request.getThirdPartyUserEmail());
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
            thirdPartyUser.setToken(loginToken);

            //返回
            String timeStamp = userService.insert(thirdPartyUser);
            if (timeStamp != null) {
                response.setId(request.getThirdPartyUserId());
                response.setKey(request.getMainKey());
                response.setLoginToken(loginToken);
                return response;
            }
            throw new Exception("Internal Server Error(insert user failed)");
        }

        //有資料
        // =>update loginToken
        thirdPartyUser.setToken(loginToken);
        String timeStamp = userService.update(thirdPartyUser);
        if (timeStamp != null) {
            // =>比對mainKey
            // =>給一組新的loginToken
            response.setId(thirdPartyUser.getId());
            response.setKey(thirdPartyUser.getMainKey().equals(request.getMainKey()) ?
                    thirdPartyUser.getMainKey() : null);
            response.setLoginToken(loginToken);
            return response;
        }
        throw new Exception("Internal Server Error(update loginToken failed)");
    }
}
