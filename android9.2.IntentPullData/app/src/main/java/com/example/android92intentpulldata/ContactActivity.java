package com.example.android92intentpulldata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        String textName = editTextName.getText().toString();
        String intCode = editTextCode.getText().toString();
        showContactActivityIntent.putExtra("Name", textName);
        showContactActivityIntent.putExtra("Code", intCode);
        startActivity(showContactActivityIntent);
        this.finish();
    }
}