package com.example.android116videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private int intPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        String pathToVideoFile = "android.resource://com.example.android116videoplayer/" + R.raw.videoplayback;
        videoView.setVideoPath(pathToVideoFile);

        if (savedInstanceState != null) {
            intPosition = savedInstanceState.getInt("intPosition");
            videoView.seekTo(intPosition);
            videoView.start();
        } else {
            videoView.start();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        videoView.seekTo(intPosition);
        videoView.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.pause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        intPosition = videoView.getCurrentPosition();
        outState.putInt("intPosition", intPosition);
    }
}
