package com.bc.eternal.subo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 共享偏好工具类
 */

public class ShareUtils {
    private static final String SHARE_NAME = "shop_common";

    public static boolean putString(Context context, String key, String value) {
        //设为私有，只有本应用能访问
        SharedPreferences mPreference = context.getSharedPreferences(SHARE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreference.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getString(Context context, String key) {
        return getString(context, key, null);
    }

    public static String getString(Context context, String key, String defaultValue) {
        //得到SharedPreferences并使用
        SharedPreferences mPreference = context.getSharedPreferences(SHARE_NAME,
                Context.MODE_PRIVATE);
        return mPreference.getString(key, defaultValue);
    }
}
