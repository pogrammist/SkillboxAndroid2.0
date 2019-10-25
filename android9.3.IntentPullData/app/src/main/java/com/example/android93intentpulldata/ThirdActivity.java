package com.example.android93intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Spinner groupSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        groupSpinner = findViewById(R.id.groupSpinner);
    }

    public void openFirstActivity(View view) {
        Intent firstActivityIntent = new Intent(this, FirstActivity.class);
        String group = groupSpinner.getSelectedItem().toString();
        firstActivityIntent.putExtra("Group", group);
        startActivity(firstActivityIntent);
    }
}
