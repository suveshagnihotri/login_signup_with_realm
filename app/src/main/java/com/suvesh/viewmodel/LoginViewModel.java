package com.suvesh.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.manaschaudhari.android_mvvm.FieldUtils;
import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.activity.ActivityRouter;
import com.suvesh.db.SharePrefrenaces;
import com.suvesh.db.ZoloDbHelper;

import rx.Observable;

/**
 * Created by Suvesh on 07/08/2017 AD.
 */

public class LoginViewModel implements ViewModel {

    public final ObservableField<String> userPhone = new ObservableField<>();
    public final ObservableField<String> passward = new ObservableField<>();

    public final ObservableField<Boolean> errorDisplay = new ObservableField<>(false);

    public final ObservableField<String> userPhoneError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(userPhone), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Phone can not be null" : null));
    public final ObservableField<String> userPasswardError = FieldUtils.toField(Observable.combineLatest(FieldUtils.toObservable(passward), FieldUtils.toObservable(errorDisplay),
            (field, errorDisplay) -> errorDisplay && (field == null || field.length() == 0) ? "User Passward can not be null" : null));
    private  Context context;
    private ZoloDbHelper dbHelper;

    public static final String MyPREFERENCES = "zolo_prefrences" ;
    public static final String ISLOGIN = "is_login";


    SharedPreferences sharedpreferences;
    public LoginViewModel(Context context){
       this.context=context;
        dbHelper = new ZoloDbHelper(context);
    }

    public  void onClickCreateAccount(){
        ActivityRouter.startSignUpActivity(context);
    }

    public  boolean validate(){
        errorDisplay.set(true);
        Boolean valid = true;
        valid = valid && (userPhoneError.get()== null);
        valid = valid && (userPasswardError.get()== null);
        return valid;
    }


    public  void loginInit(){
        if(validate()){
            if (dbHelper.checkUser(userPhone.get().toString().trim()
                    , passward.get().toString().trim())) {
                Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show();
                SharePrefrenaces.setIsLogin(context,userPhone.get().toString());
                ActivityRouter.startProfileActivity(context,userPhone.get().toString());

            } else {
                // Snack Bar to show success message that record is wrong
                Toast.makeText(context,"Please enter correct User Info", Toast.LENGTH_SHORT).show();
//                Snackbar.make(context, "Please enter correct User info", Snackbar.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(context,"Please Provide correct information", Toast.LENGTH_SHORT).show();
        }
    }
}
