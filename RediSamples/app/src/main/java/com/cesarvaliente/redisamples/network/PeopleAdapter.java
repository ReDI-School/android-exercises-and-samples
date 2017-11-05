package com.cesarvaliente.redisamples.network;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cesarvaliente.redisamples.R;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    private List<Creature> people;

    public PeopleAdapter(List<Creature> people) {
        this.people = people;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.creature_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Creature creature = people.get(position);
        holder.name.setText(creature.name);
        holder.eyeColor.setText(creature.eyeColor);
        holder.gender.setText(creature.gender);
        holder.height.setText(creature.height);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView eyeColor;
        public TextView gender;
        public TextView height;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            eyeColor = view.findViewById(R.id.eyeColor);
            gender = view.findViewById(R.id.gender);
            height = view.findViewById(R.id.height);
        }
    }
}
