package com.example.android91firstintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DarkSideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkside);
    }

    public void onChoiceActivity(View view) {
        Intent choiceActivityIntent = new Intent(this, СhoiceActivity.class);
        startActivity(choiceActivityIntent);
        this.finish();
    }

    public void onLightSideActivity(View view) {
        Intent lightsideActivityIntent = new Intent(this, LightSideActivity.class);
        startActivity(lightsideActivityIntent);
        this.finish();
    }
}