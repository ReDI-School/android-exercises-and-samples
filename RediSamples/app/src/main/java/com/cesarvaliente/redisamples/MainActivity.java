package com.cesarvaliente.redisamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.cesarvaliente.redisamples.intents.IntentsActivity;
import com.cesarvaliente.redisamples.layouts.LayoutDemoActivity;
import com.cesarvaliente.redisamples.lifecycle.LifecycleDemoActivityA;
import com.cesarvaliente.redisamples.recyclerview.RecyclerViewDemoActivity;
import com.cesarvaliente.redisamples.services.ServiceDemoActivity;

public class MainActivity extends Activity {

    private Button lifecycleDemoBtn;
    private Button layoutsDemoBtn;
    private Button servicesDemoBtn;
    private Button recyclerViewDemoBtn;
    private Button intentsDemoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        bindButtons();
    }

    private void bindButtons() {
        lifecycleDemoBtn = findViewById(R.id.lifecycleDemoBtn);
        layoutsDemoBtn = findViewById(R.id.layoutsDemo);
        servicesDemoBtn = findViewById(R.id.servicesDemoBtn);
        recyclerViewDemoBtn = findViewById(R.id.recyclerViewDemoBtn);
        intentsDemoBtn = findViewById(R.id.intentsDemoBtn);

        lifecycleDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LifecycleDemoActivityA.class);
                startActivity(intent);
            }
        });
        layoutsDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutDemoActivity.class);
                startActivity(intent);
            }
        });
        servicesDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceDemoActivity.class);
                startActivity(intent);
            }
        });

        recyclerViewDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewDemoActivity.class);
                startActivity(intent);
            }
        });

        intentsDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentsActivity.class);
                startActivity(intent);
            }
        });
    }
}
