package com.example.pwdmanage.model;

public class ThirdPartyLoginResponse {
    private String id;
//    private String email;
    private String token;
//    private Boolean newAccount;

//    public Boolean getNewAccount() {
//        return newAccount;
//    }
//
//    public void setNewAccount(Boolean newAccount) {
//        this.newAccount = newAccount;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
