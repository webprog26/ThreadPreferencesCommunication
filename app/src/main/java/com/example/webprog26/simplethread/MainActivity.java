package com.example.webprog26.simplethread;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Reader{

    private static final String TAG = "MainActivity_TAG";

    private EditText mEditText;
    private static final String KEY = "m_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferencesUtils sharedPreferencesUtils = new SharedPreferencesUtils(PreferenceManager.getDefaultSharedPreferences(this));

        mEditText = (EditText) findViewById(R.id.etText);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new OnClickHandler(KEY, mEditText, sharedPreferencesUtils));

        Button btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(new OnClickHandler(KEY, this, sharedPreferencesUtils));
    }

    @Override
    public void read(String text) {
        if(text != null){
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, getResources().getString(R.string.no_saved_text), Toast.LENGTH_SHORT).show();
    }
}
