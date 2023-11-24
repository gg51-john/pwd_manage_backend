package com.example.pwdmanage.entity;

public class ThirdPartyUser {
    private String id;
    private String provider;
    private String thirdPartyUserId;
    private String thirdPartyUserEmail;
    private String mainKey;
    private String token;
    private String registrationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public void setThirdPartyUserId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getThirdPartyUserEmail() {
        return thirdPartyUserEmail;
    }

    public void setThirdPartyUserEmail(String thirdPartyUserEmail) {
        this.thirdPartyUserEmail = thirdPartyUserEmail;
    }

    public String getMainKey() {
        return mainKey;
    }

    public void setMainKey(String mainKey) {
        this.mainKey = mainKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }
}
