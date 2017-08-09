package com.suvesh.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.manaschaudhari.android_mvvm.ViewModel;
import com.suvesh.R;
import com.suvesh.db.ZoloDbHelper;
import com.suvesh.helper.SignUpHelper;
import com.suvesh.model.User;
import com.suvesh.viewmodel.SignUpViewModel;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Suvesh on 08/08/2017 AD.
 */

public class SignUpActivity extends BaseActivity implements SignUpHelper {
    private ZoloDbHelper databaseHelper;
    private LinearLayout parentView;

    @NotNull
    @Override
    protected ViewModel createViewModel() {
        return new SignUpViewModel(this, SignUpActivity.this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_up;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentView= findViewById(R.id.mParentView);
    }

    @Override
    public void addUser(User user) {
        databaseHelper = new ZoloDbHelper(SignUpActivity.this);

        if (!databaseHelper.checkUser(user.getPhone().trim())) {
            user.setName(user.getName().trim());
            user.setEmail(user.getEmail().trim());
            user.setPhone(user.getPhone().trim());
            user.setPassword(user.getPassword().trim());

            databaseHelper.addUser(user);

            Toast.makeText(SignUpActivity.this,"DataSaved",Toast.LENGTH_SHORT).show();


        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(SignUpActivity.this,"User Aleardy Exits",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setSnakBar(String title) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
