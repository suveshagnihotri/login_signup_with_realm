package com.suvesh;

import android.app.Application;
import android.databinding.ViewDataBinding;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.manaschaudhari.android_mvvm.ViewModel;
import com.manaschaudhari.android_mvvm.adapters.ViewModelBinder;
import com.manaschaudhari.android_mvvm.utils.BindingUtils;

/**
 * Created by Suvesh on 07/08/2017 AD.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        //-- MVVM --
        BindingUtils.setDefaultBinder(new ViewModelBinder() {

            @Override
            public void bind(ViewDataBinding viewDataBinding, ViewModel viewModel) {
                viewDataBinding.setVariable(BR._all,viewModel);
            }
        });
    }
}
