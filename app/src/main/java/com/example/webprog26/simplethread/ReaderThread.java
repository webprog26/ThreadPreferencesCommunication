package com.example.webprog26.simplethread;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by webprog26 on 15.11.2016.
 */

class ReaderThread extends Thread implements InterruptChecker{

    private static final String TAG = "ReaderThread";

    private Reader mReader;
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private String mKey;

    ReaderThread(String key, Reader mReader, SharedPreferencesUtils mSharedPreferencesUtils) {
        this.mKey = key;
        this.mReader = mReader;
        this.mSharedPreferencesUtils = mSharedPreferencesUtils;

    }

    @Override
    public void run() {
        super.run();
        synchronized (this) {
            read(mKey);
        }
        if(!isThreadInterrupted()){
            interrupt();
        }
    }

    /**
     * Reads string from {@link android.content.SharedPreferences} using {@link SharedPreferencesUtils} and {@link String} as a key
     * @param key {@link String}
     */
    private void read(String key){
        final String value = mSharedPreferencesUtils.readStringFromPreferences(key);
        new Handler(Looper.getMainLooper()).post(new Runnable() {

            @Override
            public void run() {
                mReader.read(value);
            }
        });
    }

    @Override
    public boolean isThreadInterrupted() {
        return isInterrupted();
    }
}
