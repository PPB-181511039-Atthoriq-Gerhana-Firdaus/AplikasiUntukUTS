package com.example.aplikasiuntukuts.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiuntukuts.R;

import java.util.List;

public class CheeseListAdapter extends RecyclerView.Adapter<CheeseListAdapter.CheeseViewHolder> {

    class CheeseViewHolder extends RecyclerView.ViewHolder {
        private final TextView cheeseItemView;

        private CheeseViewHolder(View itemView) {
            super(itemView);
            cheeseItemView = itemView.findViewById(R.id.list);
        }
    }

    private final LayoutInflater mInflater;
    private List<Cheese> mCheeses; // Cached copy of words

    CheeseListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public CheeseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_main, parent, false);
        return new CheeseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CheeseViewHolder holder, int position) {
        if (mCheeses != null) {
            Cheese current = mCheeses.get(position);
            holder.cheeseItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.cheeseItemView.setText("No Word");
        }
    }

    void setWords(List<Cheese> cheeses){
        mCheeses = cheeses;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mCheeses != null)
            return mCheeses.size();
        else return 0;
    }
}