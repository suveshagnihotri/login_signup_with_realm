package com.suvesh.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;

import com.manaschaudhari.android_mvvm.FieldUtils;
import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.db.ZoloDbHelper;
import com.suvesh.model.User;

import rx.Observable;

/**
 * Created by Suvesh on 09/08/2017 AD.
 */

public class ProfileViewModel implements ViewModel {

    private  Context context;
    public final ObservableField<String> userPhone = new ObservableField<>();
    public final ObservableField<String> passward = new ObservableField<>();
    public final ObservableField<String> userEmail = new ObservableField<>();
    public final ObservableField<String> userName = new ObservableField<>();

    public final ObservableField<Boolean> errorDisplay = new ObservableField<>(false);

    public final ObservableField<String> userPhoneError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userPhone), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Phone can not be null" : null));
    public final ObservableField<String> userPasswardError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(passward), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Passward can not be null" : null));
    public final ObservableField<String> userNameError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userName), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Name can not be null" : null));
    public final ObservableField<String> userEmailError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userEmail), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Email can not be null" : null));

    private ZoloDbHelper dbHelper;
    private  String phone;
    private int userid;
    public  ProfileViewModel(Context context,String phone){
       this.context=context;
        this.phone = phone;
        dbHelper = new ZoloDbHelper(context);
        setDataInViews();
    }

    private void setDataInViews(){
        Log.d("Phone",phone);
        User user = dbHelper.getUser(phone);
        userid = user.getId();
        Log.d("UserName",user.getEmail());
        userName.set(user.getName());
        userEmail.set(user.getEmail());
        passward.set(user.getPassword());
        userPhone.set(user.getPhone());
    }

    private  boolean validate(){
        errorDisplay.set(true);
        Boolean valid = true;
        valid = valid && (userNameError.get()==null);
        valid = valid && (userEmailError.get()==null);
        valid = valid && (userPhoneError.get()==null);
        valid = valid && (userPasswardError.get()==null);
        return valid;
    }

    public   void  updateUserInfo(){
        Log.d("Update",""+validate());
     if(validate()) {
         User user = new User();
         user.setId(userid);
         user.setPhone(userPhone.get().toString());
         user.setPassword(passward.get().toString());
         user.setEmail(userEmail.get().toString());
         user.setName(userName.get().toString());
         dbHelper.updateUser(user);
     }
    }

}
