package com.example.dat367_projekt_11.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.ChoreCardBinding;
import com.example.dat367_projekt_11.models.Chore;

import java.util.List;

public class ChoreAdapter extends RecyclerView.Adapter<ChoreAdapter.ChoreViewHolder>{
    private List<Chore>choreModelList; //lista för kort
    private Context context;
    //private ChoreAdapterDataModel choreAdapterDataModel;


    public ChoreAdapter(List<Chore> choreModelList, Context context) {
        this.choreModelList = choreModelList;
        this.context = context;

    }

    public static class ChoreViewHolder extends RecyclerView.ViewHolder {
        public ChoreCardBinding choreCardBinding;

        public ChoreViewHolder(ChoreCardBinding choreCardBinding) {
            super(choreCardBinding.getRoot());
            this.choreCardBinding = choreCardBinding;
        }
    }


    @NonNull
    @Override
    public ChoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChoreCardBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.chore_card, parent, false);

        return new ChoreViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoreViewHolder holder, int position) {
        Chore choreModel = choreModelList.get(position);
        holder.choreCardBinding.setModel(choreModel);

    }

    @Override
    public int getItemCount() {
        return choreModelList.size();
    }


}

