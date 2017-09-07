package com.suvesh.activity;

import android.os.Bundle;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.R;
import com.suvesh.viewmodel.LoginViewModel;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends BaseActivity {

    @NotNull
    @Override
    protected ViewModel createViewModel() {
        return new LoginViewModel(LoginActivity.this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
