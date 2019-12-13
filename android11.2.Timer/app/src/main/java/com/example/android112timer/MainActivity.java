package com.example.android112timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int iterations = 0;
    boolean beginnig;
    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = findViewById(R.id.messageTextView);

        begin();
    }

    private void begin() {
        final TextView timerTextView = findViewById(R.id.timerTextView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                timerTextView.setText(String.valueOf(iterations));
                if (beginnig) {
                    iterations++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void onClickStart(View view) {
        beginnig = true;
        messageTextView.setText(R.string.start_message);
    }

    public void onClickStop(View view) {
        beginnig = false;
        iterations = 0;
        messageTextView.setText(R.string.stop_message);
    }

    public void onClickPause(View view) {
        beginnig = false;
        messageTextView.setText(R.string.pause_message);
    }
}
