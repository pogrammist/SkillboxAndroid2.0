package com.example.android93intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class SetGroupActivity extends AppCompatActivity {

    Spinner groupSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_group);

        groupSpinner = findViewById(R.id.groupSpinner);

        Intent falseMainActivityIntent = new Intent();
        setResult(RESULT_CANCELED, falseMainActivityIntent);
    }

    public void onMainActivity(View view) {
        Intent trueMainActivityIntent = new Intent();
        String group = groupSpinner.getSelectedItem().toString();
        trueMainActivityIntent.putExtra("group", group);
        setResult(RESULT_OK, trueMainActivityIntent);
        this.finish();
    }
}
