package com.binay7587.journeyjournal_cleanarchwithmvvm.login;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginModel {

    private String emailAddress, password;

    public LoginModel(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
