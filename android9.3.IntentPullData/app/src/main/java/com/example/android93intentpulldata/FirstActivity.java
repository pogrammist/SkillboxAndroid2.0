package com.example.android93intentpulldata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private static final int CODE_FOR_SECOND_ACTIVITY = 1;
    TextView nameTextView;
    TextView surnameTextView;
    TextView numberTextView;
    TextView groupTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        nameTextView = findViewById(R.id.nameTextView);
        surnameTextView = findViewById(R.id.surnameTextView);
        numberTextView = findViewById(R.id.numberTextView);
        groupTextView = findViewById(R.id.groupTextView);

        Intent getThirdActivityIntent = getIntent();
        String getGroupOfThirdActivity = getThirdActivityIntent.getStringExtra("Group");
        groupTextView.setText(getGroupOfThirdActivity);
    }

    public void openSecondActivity(View view) {
        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        startActivityForResult(secondActivityIntent, CODE_FOR_SECOND_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_FOR_SECOND_ACTIVITY && resultCode == RESULT_CANCELED) {
            nameTextView.setText(null);
            assert data != null;
            surnameTextView.setText(data.getStringExtra("answer"));
            surnameTextView.setTextColor(Color.BLACK);
//            surnameTextView.setTextColor(Color.parseColor("#FFE600"));
            numberTextView.setText(null);
        } else if (requestCode == CODE_FOR_SECOND_ACTIVITY && resultCode == RESULT_OK) {
            nameTextView.setText(data.getStringExtra("name"));
            surnameTextView.setText(data.getStringExtra("surname"));
            surnameTextView.setTextColor(Color.YELLOW);
            numberTextView.setText(data.getStringExtra("number"));
        }
    }

    public void openThirdActivity(View view) {
        Intent thirdActivityIntent = new Intent(this, ThirdActivity.class);
        startActivity(thirdActivityIntent);
    }
}