package com.example.android93intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateContactActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText surnameEditText;
    EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        numberEditText = findViewById(R.id.numberEditText);

        Intent falseMainActivityIntent = new Intent();
        setResult(RESULT_CANCELED, falseMainActivityIntent);
    }

    public void onMainActivity(View view) {
        Intent trueMainActivityIntent = new Intent();
        trueMainActivityIntent.putExtra("name", nameEditText.getText().toString());
        trueMainActivityIntent.putExtra("surname", surnameEditText.getText().toString());
        trueMainActivityIntent.putExtra("number", numberEditText.getText().toString());
        setResult(RESULT_OK, trueMainActivityIntent);
        this.finish();
    }
}