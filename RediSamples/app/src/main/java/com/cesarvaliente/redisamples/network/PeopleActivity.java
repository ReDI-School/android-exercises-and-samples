package com.cesarvaliente.redisamples.network;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cesarvaliente.redisamples.R;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static com.cesarvaliente.redisamples.network.CreatureActivity.CREATURE_EXTRA;

public class PeopleActivity extends Activity implements PeopleAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageButton previousBtn;
    private ImageButton nextBtn;
    private ProgressBar progressBar;
    private TextView pages;

    private StarWarsServiceAPI starWarsServiceAPI;
    private int page = 1;
    private int totalPages = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_layout);

        setupRecyclerView();
        bindButtons();

        setupNetwork();

        fetchPeople(page);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);

        //If we know that our list has a fixed size, this will help on performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        peopleAdapter = new PeopleAdapter(new ArrayList<Creature>(), this);
        recyclerView.setAdapter(peopleAdapter);

    }

    private void bindButtons() {
        previousBtn = findViewById(R.id.previous);
        nextBtn = findViewById(R.id.next);
        progressBar = findViewById(R.id.progressBar);
        pages = findViewById(R.id.pages);

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchPeople(--page);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchPeople(++page);
            }
        });
    }

    private void setupNetwork() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        starWarsServiceAPI = retrofit.create(StarWarsServiceAPI.class);
    }

    private void fetchPeople(final int page) {

        new AsyncTask<Void, Void, People>() {

            @Override
            protected void onPreExecute() {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected People doInBackground(Void... params) {
                try {
                    Call<People> call = starWarsServiceAPI.people(page);
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
                peopleAdapter.setAll(people.creatures);
                peopleAdapter.notifyDataSetChanged();

                progressBar.setVisibility(View.GONE);

                enableOrDisableNavigationButtons(people.previous != null, people.next != null);

                totalPages = updateTotalPages(totalPages, people.count, people.creatures.size());
                updatePagesText(page, totalPages);
            }
        }.execute();
    }

    private void enableOrDisableNavigationButtons(boolean hasPrevious, boolean hasNext) {
        previousBtn.setEnabled(hasPrevious);
        nextBtn.setEnabled(hasNext);

    }

    private int updateTotalPages(int totalPages, int totalItems, int currentPageItemsSize) {
        if (totalPages == 0) {
            return (totalItems / currentPageItemsSize) + (totalItems % currentPageItemsSize == 0 ? 0 : 1);
        } else {
            return totalPages;
        }
    }

    private void updatePagesText(int currentPage, int totalPages) {
        String text = getResources().getString(R.string.network_pages, currentPage,
                totalPages >= 0 ? totalPages : 0);
        pages.setText(text);
    }

    @Override
    public void onClick(Creature creature) {
        Intent intent = new Intent(this, CreatureActivity.class);
        intent.putExtra(CREATURE_EXTRA, creature);

        startActivity(intent);
    }
}
