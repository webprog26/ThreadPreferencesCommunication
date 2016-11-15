package com.example.webprog26.simplethread;

import android.util.Log;

/**
 * Created by webprog26 on 15.11.2016.
 */

class WriterThread extends Thread implements InterruptChecker{

    private static final String TAG = "WriterThread";

    private SharedPreferencesUtils mSharedPreferencesUtils;

    private String mKey;
    private String mValue;

    WriterThread(SharedPreferencesUtils mSharedPreferencesUtils, String key, String value) {
        this.mSharedPreferencesUtils = mSharedPreferencesUtils;
        this.mKey = key;
        this.mValue = value;
    }

    @Override
    public void run() {
        super.run();
        write(mKey, mValue);
        Log.i(TAG, this.getName() + "writing key: " + mKey + ", value: " + mValue);
        if(!isThreadInterrupted()){
            interrupt();
        }
    }

    /**
     * Writes string to {@link android.content.SharedPreferences} using {@link SharedPreferencesUtils}
     * and {@link String} as a key, {@link String} value as a value
     * @param key {@link String}
     */
    private void write(String key, String value){
        synchronized (this) {
            mSharedPreferencesUtils.write(key, value);
        }
    }

    @Override
    public boolean isThreadInterrupted() {
        return isInterrupted();
    }
}
