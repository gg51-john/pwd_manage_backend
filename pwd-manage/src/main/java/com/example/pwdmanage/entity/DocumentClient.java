package com.example.pwdmanage.entity;

public class DocumentClient {
    private String id;
    private String vendor;
    private String account;
    private String lastUpdateDate;
    private String createDate;
    private Category categoryInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Category getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(Category categoryInfo) {
        this.categoryInfo = categoryInfo;
    }
}
