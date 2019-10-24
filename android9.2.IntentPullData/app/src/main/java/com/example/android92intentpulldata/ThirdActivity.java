package com.example.android92intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView textViewName;
    TextView textViewCode;
    TextView textViewBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent getSecondActivityIntent = getIntent();
        String getNameOfSecondActivity = getSecondActivityIntent.getStringExtra("Name");
        Integer getCodeOfSecondActivity = getSecondActivityIntent.getIntExtra("Code", 0);

        textViewName = findViewById(R.id.pullName);
        textViewCode = findViewById(R.id.pullCode);
        textViewBoolean = findViewById(R.id.booleanCheck);

        textViewName.setText(getNameOfSecondActivity);
        textViewCode.setText(getCodeOfSecondActivity.toString());

        if (getCodeOfSecondActivity > 100) {
            textViewBoolean.setText("more");
        } else if (getCodeOfSecondActivity == 100) {
            textViewBoolean.setText("good");
        } else {
            textViewBoolean.setText("few");
        }
    }
}
