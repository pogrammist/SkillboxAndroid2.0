package com.example.android95intenthandlerofanyapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    Button mCallButton;
    Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);
        mCallButton = findViewById(R.id.callButton);
        mSendButton = findViewById(R.id.sendButton);
    }

    public void onWebSearch(View view) {
        Intent intentToWebSearch = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
        startActivity(Intent.createChooser(intentToWebSearch, "Choose a Browser"));
    }

    public void sendMessageToContact(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, "8-888-888-88-88");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi, dear friend!");
        // Откуда именно этот тип "text/plain"? Где применять это setType?
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void callToContact(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mEditText.getText()));

//        Intent callIntent = new Intent();
//        callIntent.setAction(Intent.ACTION_DIAL);
//        callIntent.setData(Uri.parse("tel:" + mEditText.getText()));

        startActivity(callIntent);
    }
}
