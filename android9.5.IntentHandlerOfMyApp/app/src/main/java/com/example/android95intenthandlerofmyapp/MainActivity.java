package com.example.android95intenthandlerofmyapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android95intenthandlerofmyapp.R;

public class MainActivity extends AppCompatActivity {

    TextView mNumberTextView;
    TextView mMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberTextView = findViewById(R.id.numberTextView);
        mMessageTextView = findViewById(R.id.messageTextView);

        Intent outIntent = getIntent();
        String phoneNumber = outIntent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        String message = outIntent.getStringExtra(Intent.EXTRA_TEXT);

        mNumberTextView.setText(phoneNumber);
        mMessageTextView.setText(message);
    }

}
