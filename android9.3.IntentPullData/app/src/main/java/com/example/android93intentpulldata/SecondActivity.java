package com.example.android93intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText surnameEditText;
    EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        numberEditText = findViewById(R.id.numberEditText);

        Intent falseFirstActivityIntent = new Intent();
        falseFirstActivityIntent.putExtra("answer", "type values!");
        setResult(RESULT_CANCELED, falseFirstActivityIntent);
    }

    public void openFirstActivity(View view) {
        Intent trueFirstActivityIntent = new Intent();
        trueFirstActivityIntent.putExtra("name", nameEditText.getText().toString());
        trueFirstActivityIntent.putExtra("surname", surnameEditText.getText().toString());
        trueFirstActivityIntent.putExtra("number", numberEditText.getText().toString());
        setResult(RESULT_OK, trueFirstActivityIntent);
        this.finish();
    }
}