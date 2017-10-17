package com.cesarvaliente.redisamples.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentServiceDemo extends IntentService {

    public IntentServiceDemo() {
        super("IntentServiceDemo");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("IntentServiceDemo: ", "It runs in its own thread");
        Log.d("IntentServiceDemo: ", Looper.myLooper().getThread().getName());
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            Thread.sleep(3000);
            Log.d("IntentServiceDemo: ", "Finishing...");
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
}
