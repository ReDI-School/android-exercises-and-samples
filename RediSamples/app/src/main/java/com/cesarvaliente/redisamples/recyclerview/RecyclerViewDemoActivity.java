package com.cesarvaliente.redisamples.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cesarvaliente.redisamples.R;

public class RecyclerViewDemoActivity extends Activity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private final static int NUM_ITEMS = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_demo_layout);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);

        //If we know that our list has a fixed size, this will help on performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> myData = new ArrayList();
        for (int i = 0; i < NUM_ITEMS; i++) {
            myData.add("Item " + i);
        }
        adapter = new MyAdapter(myData);
        recyclerView.setAdapter(adapter);
    }
}
