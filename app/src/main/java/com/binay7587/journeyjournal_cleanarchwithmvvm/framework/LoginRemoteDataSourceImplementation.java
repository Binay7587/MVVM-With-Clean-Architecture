package com.binay7587.journeyjournal_cleanarchwithmvvm.framework;

import com.binay7587.journeyjournal_cleanarchwithmvvm.data.sources.LoginRemoteDataSource;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginRemoteDataSourceImplementation implements LoginRemoteDataSource {

    @Override
    public LoginModel authenticateLoginRemoteServer(String email, String password) {
        return null;
    }

    @Override
    public boolean isInternetWorking() {
        return false;
    }
}
