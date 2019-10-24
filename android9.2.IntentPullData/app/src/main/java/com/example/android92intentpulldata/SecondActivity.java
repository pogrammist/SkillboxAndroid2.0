package com.example.android92intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextName = findViewById(R.id.pushName);
        editTextCode = findViewById(R.id.pushCode);
    }

    public void openThirdActivity(View view) {
        Intent thirdActivityIntent = new Intent(this, ThirdActivity.class);
        String textName = editTextName.getText().toString();
        int intCode = Integer.parseInt(editTextCode.getText().toString());
        thirdActivityIntent.putExtra("Name", textName);
        thirdActivityIntent.putExtra("Code", intCode);
        startActivity(thirdActivityIntent);
    }
}