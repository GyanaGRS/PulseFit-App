package com.example.pulsefit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pulsefit.Activity.WorkoutActivity;
import com.example.pulsefit.Domain.Workout;
import com.example.pulsefit.databinding.ViewholderWorkoutBinding;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.Viewholder> {
    private final ArrayList<Workout> list;
    private Context context;

    public WorkoutAdapter(ArrayList<Workout> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WorkoutAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        ViewholderWorkoutBinding binding= ViewholderWorkoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.Viewholder holder, int position) {
        holder.binding.titleTxtid.setText(list.get(position).getTitle());

        int resId = context.getResources().getIdentifier(list.get(position).getPicPath(), "drawable", context.getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(resId)
                .into(holder.binding.picid);

        holder.binding.excerciseTxtid.setText(list.get(position).getLessions().size() + " Exercise");
        holder.binding.kcalTxtid.setText(list.get(position).getKcal() + " kcal");
        holder.binding.durationid.setText(list.get(position).getDuration());

        // Set click listener using getAdapterPosition()
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Workout currentWorkout = list.get(currentPosition);
                    Intent intent = new Intent(context, WorkoutActivity.class);
                    intent.putExtra("object", currentWorkout);
                    context.startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderWorkoutBinding binding;
        public Viewholder(ViewholderWorkoutBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}
