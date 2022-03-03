package com.binay7587.journeyjournal_cleanarchwithmvvm.framework;

import com.binay7587.journeyjournal_cleanarchwithmvvm.data.sources.LoginLocalDataSource;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginLocalDataSourceImplementation implements LoginLocalDataSource {

    @Override
    public LoginModel authenticateLoginInLocalDatabase(String email, String password) {
        return null;
    }
}
