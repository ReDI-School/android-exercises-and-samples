package com.cesarvaliente.redisamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.cesarvaliente.redisamples.layouts.LayoutDemoActivity;
import com.cesarvaliente.redisamples.lifecycle.LifecycleDemoActivityA;
import com.cesarvaliente.redisamples.recyclerview.RecyclerViewDemoActivity;
import com.cesarvaliente.redisamples.services.ServiceDemoActivity;

public class MainActivity extends Activity {

    private Button lifecycleAndIntentsDemoBtn;
    private Button layoutsDemoBtn;
    private Button serviceseDemoBtn;
    private Button recyclerViewDemoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        bindButtons();
    }

    private void bindButtons() {
        lifecycleAndIntentsDemoBtn = findViewById(R.id.lifecycleAndIntentsDemoBtn);
        layoutsDemoBtn = findViewById(R.id.layoutsDemo);
        serviceseDemoBtn = findViewById(R.id.servicesDemoBtn);
        recyclerViewDemoBtn = findViewById(R.id.recyclerViewDemoBtn);

        lifecycleAndIntentsDemoBtn.setOnClickListener(new View.OnClickListener() {
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
        serviceseDemoBtn.setOnClickListener(new View.OnClickListener() {
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
    }
}
