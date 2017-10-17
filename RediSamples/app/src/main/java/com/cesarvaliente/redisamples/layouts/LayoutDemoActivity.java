package com.cesarvaliente.redisamples.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cesarvaliente.redisamples.R;

public class LayoutDemoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_layout_demo_layout);
    }
}
