package com.example.android91firstintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void openFirstActivity(View view) {
        Intent firstActivityIntent = new Intent(this, FirstActivity.class);
        startActivity(firstActivityIntent);
    }

    public void openSecondActivity(View view) {
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        startActivity(secondActivityIntent);
    }
}
