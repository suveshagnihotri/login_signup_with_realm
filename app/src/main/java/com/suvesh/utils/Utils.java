package com.suvesh.utils;

import android.content.res.Resources;

/**
 * Created by Suvesh on 07/08/2017 AD.
 */

public class Utils {

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

}
