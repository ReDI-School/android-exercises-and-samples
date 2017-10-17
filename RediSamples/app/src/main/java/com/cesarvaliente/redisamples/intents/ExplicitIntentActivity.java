package com.cesarvaliente.redisamples.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.cesarvaliente.redisamples.R;

public class ExplicitIntentActivity extends Activity {
    public static final String EXPLICIT_INTENT_CONTENT = "explicit_intent_content";

    private TextView explicitIntentTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicit_intent_demo_layout);

        explicitIntentTextView = findViewById(R.id.explicitIntentTextView);
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (intent != null && !intent.getStringExtra(EXPLICIT_INTENT_CONTENT).isEmpty()) {
            String content = intent.getStringExtra(EXPLICIT_INTENT_CONTENT);

            if (content != null) {
                explicitIntentTextView.setText("Date and time: " + content);
            }
        }

    }

}
