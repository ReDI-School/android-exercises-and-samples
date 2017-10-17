package com.cesarvaliente.redisamples.intents;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cesarvaliente.redisamples.R;

public class IntentsActivity extends Activity {
    private Button explicitIntentBtn;
    private Button implicitIntentBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intents_demo_layout);

        bindViews();
    }

    private void bindViews() {
        explicitIntentBtn = findViewById(R.id.explicitIntentBtn);
        implicitIntentBtn = findViewById(R.id.implicitIntentBtn);

        explicitIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explicitIntent();
            }
        });

        implicitIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implicitIntent();
            }
        });
    }

    private void explicitIntent() {
        Intent intent = new Intent(IntentsActivity.this, ExplicitIntentActivity.class);
        intent.putExtra(ExplicitIntentActivity.EXPLICIT_INTENT_CONTENT,
                Calendar.getInstance().getTime().toString());
        startActivity(intent);
    }

    private void implicitIntent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello world!");
        sendIntent.setType("text/plain");

        Intent chooser = Intent.createChooser(sendIntent, "Sharing");

        // Verify that the intent will resolve to an activity
        //If you comment the `if` condition, and you don't have any app that handles `SEND_ACTION`
        // you will see a transparent screen that says "No apps can perform this action"
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        } else {
            Toast.makeText(this, "Opss! It seems there aren't apps that can handle this action",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
