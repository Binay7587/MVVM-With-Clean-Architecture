package com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class UserModel {

    private final String emailAddress;
    private final String password;

    public UserModel(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    public String getPassword() {
        return password;
    }
}
