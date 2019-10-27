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

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_finder);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

        groupSpinner = findViewById(R.id.groupSpinner);
        groups = getResources().getStringArray(R.array.groups);

        mediaPlayer = MediaPlayer.create(this, R.raw.media_imperial_march);
        mediaPlayer.start();

        groupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedGroup = parent.getItemAtPosition(position).toString();
                switch (selectedGroup) {
                    //Как пробросить значение из массива groups в качестве case чтобы работало ru и en?
                    //Я не хочу использовать if else
                    case "Jedi":
                        // assigning div item list defined in XML to the div Spinner
                        if (mediaPlayer.isPlaying()) {
                            //Как выдержать паузу перед отключением?
                            //Как определить конкретную композицию?
                            mediaPlayer.stop();
                            mediaPlayer = MediaPlayer.create(StarWarsFinderActivity.this, R.raw.star_wars_the_last_jedi_01_main_title_and_escape);
                            mediaPlayer.start();
                        }
                        break;
                    case "Mandalorian":
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer = MediaPlayer.create(StarWarsFinderActivity.this, R.raw.star_wars_the_last_jedi_04_the_supremacy);
                            mediaPlayer.start();
                        }
                        break;
                    case "Skywalker":
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer = MediaPlayer.create(StarWarsFinderActivity.this, R.raw.star_wars_the_last_jedi_11_the_fathiers);
                            mediaPlayer.start();
                        }
                        break;
                    case "Sith":
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer = MediaPlayer.create(StarWarsFinderActivity.this, R.raw.star_wars_the_last_jedi_14_a_new_alliance);
                            mediaPlayer.start();
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onChooseStarWarsGroup(View view) {
        String selectedGroup = groupSpinner.getSelectedItem().toString();
        if (selectedGroup.equals(groups[0])) {
            int selectedImage = R.drawable.image_jedi;
            int selectedInfo = R.string.info_jedi;
            Intent jedyActivityIntent = new Intent(this, GroupActivity.class);
            jedyActivityIntent.putExtra("group", selectedGroup);
            jedyActivityIntent.putExtra("image", selectedImage);
            jedyActivityIntent.putExtra("info", selectedInfo);
            startActivity(jedyActivityIntent);
        } else if (selectedGroup.equals(groups[1])) {
            int selectedImage = R.drawable.image_mandalorian;
            int selectedInfo = R.string.info_mandalorian;
            Intent jedyActivityIntent = new Intent(this, GroupActivity.class);
            jedyActivityIntent.putExtra("group", selectedGroup);
            jedyActivityIntent.putExtra("image", selectedImage);
            jedyActivityIntent.putExtra("info", selectedInfo);
            startActivity(jedyActivityIntent);
        } else if (selectedGroup.equals(groups[2])) {
            int selectedImage = R.drawable.image_skywalker;
            int selectedInfo = R.string.info_skywalker;
            Intent jedyActivityIntent = new Intent(this, GroupActivity.class);
            jedyActivityIntent.putExtra("group", selectedGroup);
            jedyActivityIntent.putExtra("image", selectedImage);
            jedyActivityIntent.putExtra("info", selectedInfo);
            startActivity(jedyActivityIntent);
        } else if (selectedGroup.equals(groups[3])) {
            int selectedImage = R.drawable.image_sith;
            int selectedInfo = R.string.info_sith;
            Intent jedyActivityIntent = new Intent(this, GroupActivity.class);
            jedyActivityIntent.putExtra("group", selectedGroup);
            jedyActivityIntent.putExtra("image", selectedImage);
            jedyActivityIntent.putExtra("info", selectedInfo);
            startActivity(jedyActivityIntent);
        }
    }
}
