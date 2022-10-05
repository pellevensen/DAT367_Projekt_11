package com.example.dat367_projekt_11.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dat367_projekt_11.R;
import com.example.dat367_projekt_11.databinding.FragmentChoreBinding;
import com.example.dat367_projekt_11.models.Chore;

import java.util.List;

public class ChoreAdapter extends RecyclerView.Adapter<ChoreAdapter.ChoreViewHolder>{



    private List<Chore>choreModelList; //lista för kort
    private Context context;


    public ChoreAdapter(List<Chore> choreModelList, Context context) {
        this.choreModelList = choreModelList;
        this.context = context;
    }

    public static class ChoreViewHolder extends RecyclerView.ViewHolder {
        public FragmentChoreBinding choreCardBinding;

        public ChoreViewHolder(FragmentChoreBinding choreCardBinding) {
            super(choreCardBinding.getRoot());
            this.choreCardBinding = choreCardBinding;
        }
    }


    @NonNull
    @Override
    public ChoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentChoreBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.chore_card, parent, false);

        return new ChoreViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoreViewHolder holder, int position) {
        Chore choreModel = choreModelList.get(position);
        holder.choreCardBinding.setModel(choreModel);
        //holder.profileCardBinding.setItemClickListener(this);
  /*      holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return choreModelList.size();
    }

   /* @Override
    public void cardClicked(Profile profile) {
        Toast.makeText(context, "Du klickade på " + profile.getName(),
                Toast.LENGTH_LONG).show();

    }*/
}

