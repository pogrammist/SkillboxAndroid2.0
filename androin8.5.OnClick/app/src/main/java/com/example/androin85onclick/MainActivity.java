package com.example.androin85onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView textView;
    protected ImageButton imageButton;
    protected RadioButton radioButtonMan;
    protected RadioButton radioButtonWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageButton = findViewById(R.id.imageButton);
        radioButtonMan = findViewById(R.id.radioButtonMan);
        radioButtonWoman = findViewById(R.id.radioButtonWoman);
    }

    public void onClickMan(View view) {
        textView.setText("Hello Man!");
    }

    public void onClickWoman(View view) {
        textView.setText("Hello Woman!");
    }

    public void onClickHelloWorld(View view) {
        textView.setText("Hello World!");
    }
}
