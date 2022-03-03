package com.binay7587.journeyjournal_cleanarchwithmvvm.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Binaya Karki on 03,March,2022.
 */
public class LoginViewModel extends ViewModel {
    final MutableLiveData<Boolean> isEmailOrPasswordEmpty = new MutableLiveData<>();
    final MutableLiveData<Boolean> isEmailIncorrect = new MutableLiveData<>();
    final MutableLiveData<Boolean> isPasswordIncorrect = new MutableLiveData<>();
    final MutableLiveData<Boolean> isLoginSuccess = new MutableLiveData<>();


    public void validateLoginCredentials(LoginModel loginModel) {
        String emailAddress = loginModel.getEmailAddress();
        String password = loginModel.getPassword();
        if (emailAddress.isEmpty() || password.isEmpty()) {
            isEmailOrPasswordEmpty.setValue(true);
            return;
        } else {
            isEmailOrPasswordEmpty.setValue(false);
        }

        if (!emailAddress.equalsIgnoreCase("binaya@ismt.edu.np")) {
            isEmailIncorrect.setValue(true);
            return;
        } else {
            isEmailIncorrect.setValue(false);
        }

        if (!password.equals("superadmin")) {
            isPasswordIncorrect.setValue(true);
            return;
        } else {
            isPasswordIncorrect.setValue(false);
        }
        isLoginSuccess.setValue(true);
    }
}
