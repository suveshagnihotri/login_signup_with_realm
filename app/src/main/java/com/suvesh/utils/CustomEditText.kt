package com.suvesh.utils


import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.content.res.AppCompatResources
import android.util.AttributeSet
import android.widget.EditText
import com.suvesh.R

/**
 * Created by Suvesh on 08/08/2017 AD.
 */

class CustomEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.support.v7.appcompat.R.attr.editTextStyle) : EditText(context, attrs, defStyleAttr) {

    var leftVector : Int = 0
    var topVector : Int = 0
    var rightVector : Int = 0
    var bottomVector : Int = 0

    init {
        val font: Int
        if(attrs==null) {
            font = 2
        } else {
            val a: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.StyledView, defStyleAttr, 0)
            font = a.getInt(R.styleable.StyledView_font, 2)
            leftVector = a.getResourceId(R.styleable.StyledView_leftVector, 0)
            topVector = a.getResourceId(R.styleable.StyledView_topVector, 0)
            rightVector = a.getResourceId(R.styleable.StyledView_rightVector, 0)
            bottomVector = a.getResourceId(R.styleable.StyledView_bottomVector, 0)
            a.recycle()
        }
        applyCustomFont(font)
        setCompoundDrawablesWithIntrinsicBounds(leftVector, topVector, rightVector ,bottomVector)
    }

    private fun applyCustomFont(font: Int) {
        typeface = FontCache.getTypeface(font, context)
    }

    override fun setCompoundDrawablesWithIntrinsicBounds(left: Int, top: Int, right: Int, bottom: Int) {
        val context = context
        val leftDrawable = if (left != 0) AppCompatResources.getDrawable(context, left) else null
        val topDrawable = if (top != 0) AppCompatResources.getDrawable(context, top) else null
        val rightDrawable = if (right != 0) AppCompatResources.getDrawable(context, right) else null
        val bottomDrawable = if (bottom != 0) AppCompatResources.getDrawable(context, bottom) else null
        setCompoundDrawablesWithIntrinsicBounds(leftDrawable, topDrawable, rightDrawable, bottomDrawable)
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun setCompoundDrawablesRelativeWithIntrinsicBounds(start: Int, top: Int, end: Int, bottom: Int) {
        val context = context
        val startDrawable = if (start != 0) AppCompatResources.getDrawable(context, start) else null
        val topDrawable = if (top != 0) AppCompatResources.getDrawable(context, top) else null
        val endDrawable = if (end != 0) AppCompatResources.getDrawable(context, end) else null
        val bottomDrawable = if (bottom != 0) AppCompatResources.getDrawable(context, bottom) else null
        setCompoundDrawablesRelativeWithIntrinsicBounds(startDrawable, topDrawable, endDrawable, bottomDrawable)
    }

    @SuppressWarnings("deprecation")
    override fun setBackgroundResource(resid: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            background = if (resid != 0) AppCompatResources.getDrawable(context, resid) else null
        else setBackgroundDrawable(if (resid != 0) AppCompatResources.getDrawable(context, resid) else null)
    }
}