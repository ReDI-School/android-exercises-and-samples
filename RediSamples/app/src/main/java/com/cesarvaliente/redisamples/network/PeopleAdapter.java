package com.cesarvaliente.redisamples.network;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cesarvaliente.redisamples.R;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onClick(Creature creature);
    }

    private List<Creature> people;
    private final OnItemClickListener onItemClickListener;

    public PeopleAdapter(List<Creature> people, OnItemClickListener onItemClickListener) {
        this.people = people;
        this.onItemClickListener = onItemClickListener;
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
        holder.bind(creature, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public void setAll(List<Creature> people) {
        this.people = people;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
        }

        public void bind(final Creature creature,
                         final OnItemClickListener onItemClickListener) {

            name.setText(creature.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(creature);
                }
            });
        }
    }
}
