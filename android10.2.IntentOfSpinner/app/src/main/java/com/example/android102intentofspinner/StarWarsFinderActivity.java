package com.example.android102intentofspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class StarWarsFinderActivity extends AppCompatActivity {

    Spinner groupSpinner;
    String[] groups;
    Group group;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_finder);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

        groupSpinner = findViewById(R.id.groupSpinner);
        groups = getResources().getStringArray(R.array.groups);
        group = new Group(groups);

//        mediaPlayer = MediaPlayer.create(this, R.raw.media_imperial_march);
//        mediaPlayer.start();

        groupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int melody = group.getMelody(position);
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(StarWarsFinderActivity.this, melody);
                mediaPlayer.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onChooseStarWarsGroup(View view) {
        Card card = group.getCard();
        String selectedGroup = card.getName();
        int selectedImage = card.getImage();
        int selectedInfo = card.getInfo();
        Intent jedyActivityIntent = new Intent(this, GroupActivity.class);
        jedyActivityIntent.putExtra("group", selectedGroup);
        jedyActivityIntent.putExtra("image", selectedImage);
        jedyActivityIntent.putExtra("info", selectedInfo);
        startActivity(jedyActivityIntent);
    }
}
