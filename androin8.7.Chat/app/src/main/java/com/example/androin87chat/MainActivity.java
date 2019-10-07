package com.example.androin87chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androin87chat.R;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerUsers;
    Spinner spinnerGroups;
    TextView textViewUser;
    TextView textViewGroup;
    TextView textViewMessage;
    EditText editTextMessage;
    Button buttonSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerUsers = findViewById(R.id.spinnerUsers);
        spinnerGroups = findViewById(R.id.spinnerGroups);
        textViewUser = findViewById(R.id.textViewUser);
        textViewGroup = findViewById(R.id.textViewGroup);
        textViewMessage = findViewById(R.id.textViewMessage);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
    }

    public void sendMessage(View view) {
        textViewMessage.setText(editTextMessage.getText());
        textViewUser.setText(spinnerUsers.getSelectedItem().toString());
        textViewGroup.setText(spinnerGroups.getSelectedItem().toString());

    }
}
