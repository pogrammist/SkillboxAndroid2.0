package com.example.android95intenthandlerofanyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
    }

    public void onAuthorRepository(View view) {
        Intent intentToWebSearch = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pogrammist"));
        startActivity(Intent.createChooser(intentToWebSearch, "Choose a Browser"));
    }
}
