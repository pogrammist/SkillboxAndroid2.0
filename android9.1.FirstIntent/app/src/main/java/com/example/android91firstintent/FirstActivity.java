package com.example.android91firstintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void openSecondActivity(View view) {
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(secondActivityIntent);
    }
    public void openThirdActivity(View view) {
        Intent thirdActivityIntent = new Intent(this, ThirdActivity.class);
        startActivity(thirdActivityIntent);
    }
}