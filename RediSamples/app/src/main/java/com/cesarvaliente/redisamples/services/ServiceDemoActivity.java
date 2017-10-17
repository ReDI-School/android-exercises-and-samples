package com.cesarvaliente.redisamples.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.cesarvaliente.redisamples.R;

public class ServiceDemoActivity extends Activity {
    private Button serviceDemoSyncBtn;
    private Button serviceDemoAscynBtn;
    private Button intentServiceDemoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_demo_layout);

        bindViews();
    }

    private void bindViews() {
        serviceDemoSyncBtn = findViewById(R.id.serviceSyncDemoBtn);
        serviceDemoAscynBtn = findViewById(R.id.serviceAsyncDemoBtn);
        intentServiceDemoBtn = findViewById(R.id.intentServiceDemoBtn);

        serviceDemoSyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDemoActivity.this, ServiceDemo.class);
                startService(intent);
            }
        });

        serviceDemoAscynBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDemoActivity.this, ServiceDemo.class);
                intent.putExtra(ServiceDemo.OTHER_THREAD, true);
                startService(intent);
            }
        });

        intentServiceDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDemoActivity.this, IntentServiceDemo.class);
                startService(intent);
            }
        });
    }
}
