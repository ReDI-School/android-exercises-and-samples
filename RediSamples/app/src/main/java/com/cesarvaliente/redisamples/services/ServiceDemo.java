package com.cesarvaliente.redisamples.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceDemo extends Service {

    public static final String OTHER_THREAD = "other_thread";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("DemoService: ", "onStartCommand");
        if (intent != null) {
            boolean shouldRunAsync = intent.getBooleanExtra(OTHER_THREAD, false);
            if (shouldRunAsync) {
                HandlerThread handlerThread = new HandlerThread("handlerThread");
                handlerThread.start();
                new Handler(handlerThread.getLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("DemoService", "this is running asynchronous");
                        Log.d("IntentServiceDemo: ", Looper.myLooper().getThread().getName());
                        stopSelf();
                    }
                });
            } else {
                Log.d("DemoService", "This is running in the main thread");
                Log.d("IntentServiceDemo: ", Looper.myLooper().getThread().getName());
                stopSelf();
            }
        }
        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("DemoService: ", "onBind");
        return null;
    }
}
