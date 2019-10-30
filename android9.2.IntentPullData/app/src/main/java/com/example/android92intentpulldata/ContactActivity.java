package com.example.android92intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        editTextName = findViewById(R.id.pushName);
        editTextCode = findViewById(R.id.pushCode);
    }

    public void onShowContactActivity(View view) {
        Intent showContactActivityIntent = new Intent(this, ShowContactActivity.class);
        Bundle extras = new Bundle();

        String textName = String.valueOf(editTextName.getText());
        String textCode = String.valueOf(editTextCode.getText());

        int intCode = textCode.equals("") ? 0 : Integer.parseInt(textCode);

        extras.putString("Name", textName);
        extras.putInt("Code", intCode);

        showContactActivityIntent.putExtras(extras);

        startActivity(showContactActivityIntent);
        this.finish();
    }
}