package com.binay7587.journeyjournal_cleanarchwithmvvm.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.binay7587.journeyjournal_cleanarchwithmvvm.R;
import com.binay7587.journeyjournal_cleanarchwithmvvm.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViewModel();
        initViews();
        initLoginButtonAction();
        observeMutableLiveData();
    }

    private void bindViewModel() {
        loginViewModel = new ViewModelProvider(LoginActivity.this)
                .get(LoginViewModel.class);
    }

    private void initViews() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void initLoginButtonAction() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClicked();
            }
        });
    }

    private void onLoginButtonClicked() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        LoginModel loginModel = new LoginModel(email, password);
        loginViewModel.validateLoginCredentials(loginModel);
    }

    private void observeMutableLiveData() {
        observeIsEmailOrPasswordEmptyLiveData();
        observeIsEmailIncorrect();
        observeIsPasswordIncorrectLiveData();
        observeIsLoginSuccessLiveData();
    }

    private void observeIsEmailOrPasswordEmptyLiveData() {
        loginViewModel.isEmailOrPasswordEmpty.observe(
                LoginActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isEmpty) {
                        if (isEmpty) {
                            Toast.makeText(LoginActivity.this, "Email or Password is Empty", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void observeIsEmailIncorrect() {
        loginViewModel.isEmailIncorrect.observe(
                LoginActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isEmailIncorrect) {
                        if (isEmailIncorrect) {
                            Toast.makeText(
                                    LoginActivity.this,
                                    "Email is incorrect",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                });
    }

    private void observeIsPasswordIncorrectLiveData() {
        loginViewModel.isPasswordIncorrect.observe(
                LoginActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isPasswordIncorrect) {
                        if (isPasswordIncorrect) {
                            Toast.makeText(
                                    LoginActivity.this,
                                    "Password is incorrect",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                });
    }

    private void observeIsLoginSuccessLiveData() {
        loginViewModel.isLoginSuccess.observe(
                LoginActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isLoginSuccess) {
                        if (isLoginSuccess) {
                            Toast.makeText(
                                    LoginActivity.this,
                                    "Login Success",
                                    Toast.LENGTH_SHORT
                            ).show();
                            startHome();
                        }
                    }
                });
    }

    private void startHome() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

}