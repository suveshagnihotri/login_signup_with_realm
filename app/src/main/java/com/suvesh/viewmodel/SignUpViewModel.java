package com.suvesh.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;

import com.manaschaudhari.android_mvvm.FieldUtils;
import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.activity.ActivityRouter;
import com.suvesh.helper.SignUpHelper;
import com.suvesh.model.User;

import rx.Observable;

/**
 * Created by Suvesh on 08/08/2017 AD.
 */

public class SignUpViewModel implements ViewModel {

    private Context context;
    private SignUpHelper signUpHelper;
    public final ObservableField<Boolean> errorDisplay = new ObservableField<>(false);
    public final ObservableField<String> userEmail = new ObservableField<>();
    public final ObservableField<String> userName = new ObservableField<>();
    public final ObservableField<String> userPassward = new ObservableField<>();
    public final ObservableField<String> userPhone = new ObservableField<>();
    public final ObservableField<String> userEmailError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userEmail), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "UserEmail can not be null" : null));
    public final ObservableField<String> userNameError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userName), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Name can not be null" : null));
    public final ObservableField<String> userPasswardError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userPassward), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Name can not be null" : null));
    public final ObservableField<String> userPhoneError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userPhone), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Name can not be null" : null));
    public SignUpViewModel(SignUpHelper signUpHelper,Context context) {
        this.context = context;
        this.signUpHelper=signUpHelper;
    }

    public boolean validate(){
        errorDisplay.set(true);
        Boolean valid = true;
        valid = valid && (userEmailError.get()==null);
        valid = valid && (userNameError.get()==null);
        valid = valid && (userPasswardError.get()==null);
        valid = valid && (userPhoneError.get()==null);
        return  valid;
    }

    public void onClickLogIn(){
        ActivityRouter.startLoginActivity(context);
    }

    public  void createUser(){
        if(validate()){
            User user = new User();
            user.setPhone(userPhone.get().toString());
            user.setEmail(userEmail.get().toString());
            user.setName(userName.get().toString());
            user.setPassword(userPassward.get().toString());
            signUpHelper.addUser(user);
        }
    }
}
