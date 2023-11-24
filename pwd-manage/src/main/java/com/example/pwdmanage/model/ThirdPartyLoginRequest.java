package com.example.pwdmanage.model;

public class ThirdPartyLoginRequest {
    private String provider;
    private String thirdPartyUserId;
    private String thirdPartyUserEmail;
    private String mainKey;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public void setThirdPartyUserId(String thirdPartyUserId) {
        this.thirdPartyUserId = thirdPartyUserId;
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
}
