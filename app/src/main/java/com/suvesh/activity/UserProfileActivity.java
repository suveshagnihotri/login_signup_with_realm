package com.suvesh.activity;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.viewmodel.ProfileViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Suvesh on 09/08/2017 AD.
 */

public class UserProfileActivity extends  BaseActivity {
    @NotNull
    @Override
    protected ViewModel createViewModel() {
        return new ProfileViewModel(UserProfileActivity.this);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
