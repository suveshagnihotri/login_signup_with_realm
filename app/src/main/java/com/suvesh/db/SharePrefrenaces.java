package com.suvesh.db;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Suvesh on 10/08/2017 AD.
 */

public class SharePrefrenaces {

    private static SharedPreferences appSharedPrefs;
    private static final String FILE_NAME = "zolo_prefrences";
    private static  final  String PREF_PHONE="phone";


    public static SharedPreferences getSharedPreferences(Context context) {
        if (appSharedPrefs == null) {
            appSharedPrefs = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return appSharedPrefs;
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defValue) {
        return getSharedPreferences(context).getString(key, defValue);
    }

    public static void setIsLogin(Context context, String phone) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_PHONE, phone);
        editor.apply();
    }

    public static String getIsLogin(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.getString(PREF_PHONE,null );
    }

}
