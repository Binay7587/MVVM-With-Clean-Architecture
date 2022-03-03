package com.binay7587.journeyjournal_cleanarchwithmvvm.framework;

import com.binay7587.journeyjournal_cleanarchwithmvvm.data.sources.LoginLocalDataSource;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.UserModel;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginLocalDataSourceImplementation implements LoginLocalDataSource {

    @Override
    public LoginModel authenticateLoginInLocalDatabase(String email, String password) {

        if (email.equals("Binaya@ismt.edu.np") && password.equals("superadmin")) {
            LoginModel loginModel = new LoginModel(true, "User Logged in succcessful");
            loginModel.setUser(new UserModel("Binaya@ismt.edu.np", "superadmin"));
            return loginModel;
        } else {
            LoginModel loginModel = new LoginModel(false, "User failed to login");
            loginModel.setUser(null);
            return loginModel;
        }
    }
}
