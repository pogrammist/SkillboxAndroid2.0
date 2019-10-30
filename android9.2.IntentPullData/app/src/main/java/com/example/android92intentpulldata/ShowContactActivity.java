package com.example.android92intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowContactActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewCode;
    TextView textViewBoolean;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);

        Intent getContactActivityIntent = getIntent();

        Bundle extras = getContactActivityIntent.getExtras();

        assert extras != null;
        String getNameOfSecondActivity = extras.getString("Name");
        int getCodeOfSecondActivity = extras.getInt("Code", 0);

        textViewName = findViewById(R.id.pullName);
        textViewCode = findViewById(R.id.pullCode);
        textViewBoolean = findViewById(R.id.booleanCheck);

        textViewName.setText(getNameOfSecondActivity);
        textViewCode.setText(String.valueOf(getCodeOfSecondActivity));

        if (getCodeOfSecondActivity > 100) {
            textViewBoolean.setText("more");
        } else if (getCodeOfSecondActivity == 100) {
            textViewBoolean.setText("good");
        } else {
            textViewBoolean.setText("few");
        }
    }
}
