package com.example.hfe;

public class User_Details {
    String name, email, phone, home_addr,userType, token;

    public User_Details(String name, String email, String phone, String home_addr, String userType, String token) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.home_addr = home_addr;
        this.userType = userType;
        this.token = token;
    }

    public User_Details() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHome_addr() {
        return home_addr;
    }

    public void setHome_addr(String home_addr) {
        this.home_addr = home_addr;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
