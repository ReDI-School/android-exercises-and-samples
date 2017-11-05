package com.cesarvaliente.redisamples.network;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cesarvaliente.redisamples.R;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class PeopleActivity extends Activity {
    private RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_demo_layout);

        setupRecyclerView();

        makeRequest();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);

        //If we know that our list has a fixed size, this will help on performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void makeRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        final StarWarsServiceAPI starWarsServiceAPI = retrofit.create(StarWarsServiceAPI.class);

        new AsyncTask<Void, Void, People>() {

            @Override
            protected People doInBackground(Void... params) {
                try {
                    Call<People> call = starWarsServiceAPI.people(1);
                    Response<People> response = call.execute();
                    People people = response.body();

                    return people;

                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(People people) {
                super.onPostExecute(people);
                peopleAdapter = new PeopleAdapter(people.creatures);
                recyclerView.setAdapter(peopleAdapter);
            }
        }.execute();
    }

}
