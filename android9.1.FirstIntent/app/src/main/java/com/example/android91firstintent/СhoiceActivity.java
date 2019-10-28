package com.example.android91firstintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class СhoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void onDarkSideActivity(View view) {
        Intent secondActivityIntent = new Intent(this, DarkSideActivity.class);
        startActivity(secondActivityIntent);
        this.finish();
    }
    public void onLightSideActivity(View view) {
        Intent thirdActivityIntent = new Intent(this, LightSideActivity.class);
        startActivity(thirdActivityIntent);
        this.finish();
    }
}