package com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginModel {

    private final boolean isLoginSuccess;
    private final String message;
    private UserModel user;

    public UserModel getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public LoginModel(boolean isLoginSuccess, String message) {
        this.isLoginSuccess = isLoginSuccess;
        this.message = message;
    }
}
