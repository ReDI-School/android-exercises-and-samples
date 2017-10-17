package com.cesarvaliente.redisamples.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cesarvaliente.redisamples.R;

public class LifecycleDemoActivityA extends Activity {

    private Button changeActivityBtn;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle_demo_layout);

        bindViews();
        printState("onCreate");
    }

    private void bindViews() {
        textView = findViewById(R.id.textview);
        changeActivityBtn = findViewById(R.id.changeActivityBtn);

        textView.setText(R.string.lifecycle_text_activity_a);
        changeActivityBtn.setText(R.string.lifecycle_to_activity_b);
        changeActivityBtn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        changeActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifecycleDemoActivityA.this, LifecycleDemoActivityB.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        printState("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        printState("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        printState("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        printState("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        printState("onDestroy");
    }

    private void printState(String state) {
        if (textView != null) {
            textView.setText(textView.getText() + "\t\n" + state);
        }
        Log.d("Activity A state: ", state);
    }
}
