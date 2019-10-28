package com.example.android93intentpulldata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int CODE_FOR_CREATE_CONTACT_ACTIVITY = 1;
    private static final int CODE_FOR_SET_GROUP_ACTIVITY = 2;
    TextView nameTextView;
    TextView surnameTextView;
    TextView numberTextView;
    TextView groupTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.nameTextView);
        surnameTextView = findViewById(R.id.surnameTextView);
        numberTextView = findViewById(R.id.numberTextView);
        groupTextView = findViewById(R.id.groupTextView);
    }

    public void onCreateContactActivity(View view) {
        Intent createContactActivityIntent = new Intent(this, CreateContactActivity.class);
        startActivityForResult(createContactActivityIntent, CODE_FOR_CREATE_CONTACT_ACTIVITY);
    }

    public void onSetGroupActivity(View view) {
        Intent setGroupActivityIntent = new Intent(this, SetGroupActivity.class);
        startActivityForResult(setGroupActivityIntent, CODE_FOR_SET_GROUP_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_FOR_CREATE_CONTACT_ACTIVITY && resultCode == RESULT_CANCELED) {
            assert data != null;
            nameTextView.setText(R.string.name);
            nameTextView.setTextColor(Color.BLACK);
            surnameTextView.setText(R.string.surname);
            surnameTextView.setTextColor(Color.BLACK);
            numberTextView.setText(R.string.number);
            numberTextView.setTextColor(Color.BLACK);

        } else if (requestCode == CODE_FOR_CREATE_CONTACT_ACTIVITY && resultCode == RESULT_OK) {
            assert data != null;
            nameTextView.setText(data.getStringExtra("name"));
            nameTextView.setTextColor(Color.YELLOW);
            surnameTextView.setText(data.getStringExtra("surname"));
            surnameTextView.setTextColor(Color.YELLOW);
            numberTextView.setText(data.getStringExtra("number"));
            numberTextView.setTextColor(Color.YELLOW);

        } else if (requestCode == CODE_FOR_SET_GROUP_ACTIVITY && resultCode == RESULT_CANCELED) {
            assert data != null;
            groupTextView.setText(R.string.group);
            groupTextView.setTextColor(Color.BLACK);

        } else if (requestCode == CODE_FOR_SET_GROUP_ACTIVITY && resultCode == RESULT_OK) {
            assert data != null;
            groupTextView.setText(data.getStringExtra("group"));
            groupTextView.setTextColor(Color.YELLOW);
        }
    }
}