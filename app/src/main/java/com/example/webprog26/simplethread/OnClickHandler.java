package com.example.webprog26.simplethread;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by webprog26 on 15.11.2016.
 */

class OnClickHandler implements View.OnClickListener {

    private static final String TAG = "OnClickHandler";

    private String mKey;
    private EditText mEditText;
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private Reader mReader;

    OnClickHandler(String key, EditText editText, SharedPreferencesUtils sharedPreferencesUtils) {
        this.mKey = key;
        this.mEditText = editText;
        this.mSharedPreferencesUtils = sharedPreferencesUtils;
    }

    OnClickHandler(String mKey, Reader reader, SharedPreferencesUtils sharedPreferencesUtils) {
        this.mKey = mKey;
        this.mReader = reader;
        this.mSharedPreferencesUtils = sharedPreferencesUtils;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                String value = mEditText.getText().toString();
                Log.i(TAG, "value = " + value);
                new WriterThread(mSharedPreferencesUtils, mKey, value).start();
                break;
            case R.id.btnRead:
                new ReaderThread(mKey, mReader, mSharedPreferencesUtils).start();
                break;
        }
    }
}
