package com.suvesh.activity;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.R;
import com.suvesh.viewmodel.ProfileViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Suvesh on 09/08/2017 AD.
 */

public class UserProfileActivity extends  BaseActivity {

    public static  final  String USER_PHONE ="user_phone";
    @NotNull
    @Override
    protected ViewModel createViewModel() {
        return new ProfileViewModel(UserProfileActivity.this,getIntent().getStringExtra(USER_PHONE));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_profile;
    }
}
