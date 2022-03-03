package com.binay7587.journeyjournal_cleanarchwithmvvm.domain.usecases;

import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;
import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.repositories.LoginRepository;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginAuthenticationUseCase {

    private final LoginRepository loginRepository;

    public LoginAuthenticationUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginModel authenticateLogin(String email, String password){
        return loginRepository.authenticateLogin(email, password);
    }
}
