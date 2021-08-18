package com.farkas.jobsearch.authentication;

public class LoginData {

    private String email;
    private String password;
    private boolean type;

    public LoginData() {
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getType() {
        return type;
    }
    public void setType(boolean type) {
        this.type = type;
    }
}
