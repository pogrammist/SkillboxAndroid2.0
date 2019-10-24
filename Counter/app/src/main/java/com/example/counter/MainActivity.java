package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCounter;
    private TextView mIntTextView;
    // Имя файла настроек и имя параметра
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        mIntTextView = findViewById(R.id.intTextView);
    }

    public void onClick(View v) {
        ++mCounter;
        mIntTextView.setText(String.valueOf(mCounter));
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
            // Чтение параметра из файла настроек
            mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
            mIntTextView.setText(String.valueOf(mCounter));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запись параметров
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
        editor.apply();
    }

    public void onClose (View view) {
        this.finish();
    }
}