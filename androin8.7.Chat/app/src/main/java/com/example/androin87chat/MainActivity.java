package com.example.androin87chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androin87chat.R;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerUsers, spinnerGroups;
    TextView textViewUser, textViewGroup, textViewMessage;
    EditText editTextMessage;
    Button buttonSendMessage;
    String selectedGroup, selectedUser;

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

        spinnerGroups.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // do something upon option selection
                String selectedClass = parent.getItemAtPosition(position).toString();
                switch (selectedClass) {
                    case "Developer":
                        // assigning div item list defined in XML to the div Spinner
                        spinnerUsers.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.users_1)));
                        break;

                    case "HandMade":
                        spinnerUsers.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.users_2)));
                        break;

                    case "Freelancer":
                        spinnerUsers.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                getResources().getStringArray(R.array.users_3)));
                        break;
                }

                //set divSpinner Visibility to Visible
//                spinnerUsers.setVisibility(View.VISIBLE);

                textViewGroup.setText(spinnerGroups.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }
        });

        spinnerUsers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // do something upon option selection
                selectedUser = parent.getItemAtPosition(position).toString();
                /*
                    Now that we have both values, lets create a Toast to
                    show the values on screen
                */
                Toast.makeText(MainActivity.this, "\n Class: \t " + selectedGroup +
                        "\n Div: \t" + selectedUser, Toast.LENGTH_LONG).show();

                textViewUser.setText(spinnerUsers.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // can leave this empty
            }

        });
    }

    public void sendMessage(View view) {
        textViewMessage.setText(editTextMessage.getText());
    }
}
