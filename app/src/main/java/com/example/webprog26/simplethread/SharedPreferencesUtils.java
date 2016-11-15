package com.example.webprog26.simplethread;

import android.content.SharedPreferences;

/**
 * Created by webprog26 on 15.11.2016.
 */

class SharedPreferencesUtils {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    SharedPreferencesUtils(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
        this.mEditor = mSharedPreferences.edit();
    }

    void write(String key, String value){
        mEditor.putString(key, value).commit();
    }

    String readStringFromPreferences(String key){
        return mSharedPreferences.getString(key, null);
    }
}
