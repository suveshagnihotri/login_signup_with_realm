package com.suvesh.activity;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.R;
import com.suvesh.viewmodel.LoginViewModel;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends BaseActivity {

    @NotNull
    @Override
    protected ViewModel createViewModel() {

        return new LoginViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
