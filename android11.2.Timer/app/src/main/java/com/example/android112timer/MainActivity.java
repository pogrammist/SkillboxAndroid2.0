package com.example.android112timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageTextView;

    int iterations = 0;
    boolean beginning;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = findViewById(R.id.messageTextView);

        if (savedInstanceState != null) {
            iterations = savedInstanceState.getInt("iterations", iterations);
            beginning = savedInstanceState.getBoolean("beginning", beginning);
            messageTextView.setText(savedInstanceState.getString("message", message));
        }

        begin();
    }

    private void begin() {
        final TextView timerTextView = findViewById(R.id.timerTextView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                timerTextView.setText(String.valueOf(iterations));
                if (beginning) {
                    iterations++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onClickStart(View view) {
        beginning = true;
        messageTextView.setText(R.string.start_message);
    }

    public void onClickStop(View view) {
        beginning = false;
        iterations = 0;
        messageTextView.setText(R.string.stop_message);
    }

    public void onClickPause(View view) {
        beginning = false;
        messageTextView.setText(R.string.pause_message);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("iterations", iterations);
        outState.putBoolean("beginning", beginning);
        outState.putString("message", String.valueOf(messageTextView.getText()));
    }
}
