package com.suvesh.activity;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.viewmodel.ForgetPasswardViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Suvesh on 10/08/2017 AD.
 */

public class ForgetPasswardActivity extends  BaseActivity {
    @NotNull
    @Override
    protected ViewModel createViewModel() {
        return new ForgetPasswardViewModel(ForgetPasswardActivity.this);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
