package com.binay7587.journeyjournal_cleanarchwithmvvm.data.sources;

import com.binay7587.journeyjournal_cleanarchwithmvvm.domain.models.LoginModel;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public interface LoginLocalDataSource {

    LoginModel authenticateLoginInLocalDatabase(String email, String password);
}
