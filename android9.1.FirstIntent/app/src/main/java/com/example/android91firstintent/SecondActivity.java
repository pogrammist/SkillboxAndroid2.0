package com.example.android91firstintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void openFirstActivity(View view) {
        Intent firstActivityIntent = new Intent(this, FirstActivity.class);
        startActivity(firstActivityIntent);
    }

    public void openThirdActivity(View view) {
        Intent thirdActivityIntent = new Intent(this, ThirdActivity.class);
        startActivity(thirdActivityIntent);
    }
}