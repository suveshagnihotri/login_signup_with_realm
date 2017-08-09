package com.suvesh.viewmodel;

import android.content.Context;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.activity.ActivityRouter;

/**
 * Created by Suvesh on 07/08/2017 AD.
 */

public class LoginViewModel implements ViewModel {

    private  Context context;
    public LoginViewModel(Context context){
       this.context=context;
    }

    public  void onClickCreateAccount(){
        ActivityRouter.startSignUpActivity(context);
    }
}
