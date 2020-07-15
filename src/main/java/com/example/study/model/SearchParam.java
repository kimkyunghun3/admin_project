package com.example.study.model;

public class SearchParam {

    private String account;
    private String email;
    private int page;

    public String getAccount() {            //code -> generate -> getter and setter 클릭으로 자동으로 객체 생성한다
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
