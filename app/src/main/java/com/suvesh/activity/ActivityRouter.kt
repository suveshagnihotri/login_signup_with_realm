package com.suvesh.activity

import android.content.Context
import android.content.Intent
import java.io.Serializable
import java.util.*

/**
 * Created by Suvesh on 08/08/2017 AD.
 */

object  ActivityRouter{

    @JvmStatic
    fun startLoginActivity(context: Context) {
        val extras = HashMap<String, Serializable?>()
        val intent = BaseActivity.newIntent(context, extras, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }

    @JvmStatic
    fun startSignUpActivity(context: Context) {
        val extras = HashMap<String, Serializable?>()
        val intent = BaseActivity.newIntent(context, extras, SignUpActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }

    @JvmStatic
    fun startProfileActivity(context: Context,phone:String) {
        val extras = HashMap<String, Serializable?>()
        extras.put(UserProfileActivity.USER_PHONE,phone)
        val intent = BaseActivity.newIntent(context, extras, UserProfileActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }



}