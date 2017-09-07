package com.suvesh.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.suvesh.R;
import com.suvesh.db.SharePrefrenaces;

/**
 * Created by Suvesh on 10/08/2017 AD.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                navigateToNext();
                finish();
            }
        }, 3000);
    }

    private void navigateToNext(){
        if(SharePrefrenaces.getIsLogin(SplashActivity.this)!=null)
            ActivityRouter.startProfileActivity(SplashActivity.this,SharePrefrenaces.getIsLogin(SplashActivity.this));
        else
            ActivityRouter.startLoginActivity(SplashActivity.this);
    }
}
