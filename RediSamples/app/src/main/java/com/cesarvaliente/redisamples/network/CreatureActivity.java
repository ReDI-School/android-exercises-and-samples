package com.cesarvaliente.redisamples.network;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.cesarvaliente.redisamples.R;

public class CreatureActivity extends Activity {

    public static final String CREATURE_EXTRA = "creatureExtra";

    private TextView name;
    private TextView eyeColor;
    private TextView gender;
    private TextView height;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creature_layout);

        bindViews();
        fillFields(getIntent());
    }

    private void bindViews() {
        name = findViewById(R.id.name);
        eyeColor = findViewById(R.id.eyeColor);
        gender = findViewById(R.id.gender);
        height = findViewById(R.id.height);
    }

    private void fillFields(Intent intent) {

        if (intent != null && intent.hasExtra(CREATURE_EXTRA)) {
            Creature creature = intent.getParcelableExtra(CREATURE_EXTRA);

            name.setText(creature.name);

            String eyeColorText = getResources().getString(R.string.network_people_eye_color, creature.eyeColor);
            eyeColor.setText(eyeColorText);

            String genderText = getResources().getString(R.string.network_people_gender, creature.gender);
            gender.setText(genderText);

            String heightText = getResources().getString(R.string.network_people_height, creature.height);
            height.setText(heightText);
        }
    }
}
