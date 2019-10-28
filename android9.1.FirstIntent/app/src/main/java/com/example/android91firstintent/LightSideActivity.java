package com.example.android91firstintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LightSideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightside);
    }

    public void onChoiceActivity(View view) {
        Intent firstActivityIntent = new Intent(this, СhoiceActivity.class);
        startActivity(firstActivityIntent);
        this.finish();
    }

    public void onDarkSideActivity(View view) {
        Intent secondActivityIntent = new Intent(this, DarkSideActivity.class);
        startActivity(secondActivityIntent);
        this.finish();
    }
}
