package com.binay7587.journeyjournal_cleanarchwithmvvm.data.repositories;

import com.binay7587.journeyjournal_cleanarchwithmvvm.data.sources.LoginLocalDataSource;
import com.binay7587.journeyjournal_cleanarchwithmvvm.data.sources.LoginRemoteDataSource;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.repositories.LoginRepository;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginRepoImplementation implements LoginRepository {

    private final LoginRemoteDataSource loginRemoteDataSource;
    private final LoginLocalDataSource loginLocalDataSource;

    public LoginRepoImplementation(LoginRemoteDataSource loginRemoteDataSource, LoginLocalDataSource loginLocalDataSource) {
        this.loginRemoteDataSource = loginRemoteDataSource;
        this.loginLocalDataSource = loginLocalDataSource;
    }

    @Override
    public LoginModel authenticateLogin(String email, String password) {
        boolean isInternetWorking = loginRemoteDataSource.isInternetWorking();
        if (isInternetWorking){
            return loginRemoteDataSource.authenticateLoginRemoteServer(email, password);
        }else {
            return  loginLocalDataSource.authenticateLoginInLocalDatabase(email, password);
        }
    }

}
