package com.binay7587.journeyjournal_cleanarchwithmvvm.domain.repositories;

import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public interface LoginRepository {

    LoginModel authenticateLogin(String email, String password);
}
