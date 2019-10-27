package com.example.android102intentofspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GroupActivity extends AppCompatActivity {

    TextView mGroupTextView;
    ImageView mImageView;
    TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        mGroupTextView = findViewById(R.id.groupView);
        mImageView = findViewById(R.id.imageView);
        mInfoTextView = findViewById(R.id.infoTextView);

        Intent ofStarWarsFinderIntent = getIntent();

        String group = ofStarWarsFinderIntent.getStringExtra("group");
        int image = ofStarWarsFinderIntent.getIntExtra("image",0);
        int info = ofStarWarsFinderIntent.getIntExtra("info",0);

        mGroupTextView.setText(group);
        mImageView.setImageResource(image);
        mInfoTextView.setText(info);
    }
}