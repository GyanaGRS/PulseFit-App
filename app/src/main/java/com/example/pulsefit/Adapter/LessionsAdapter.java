package com.example.pulsefit.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pulsefit.Domain.Lession;
import com.example.pulsefit.databinding.ViewholderExerciseBinding;
import com.example.pulsefit.databinding.ViewholderWorkoutBinding;

import java.util.ArrayList;

public class LessionsAdapter extends RecyclerView.Adapter<LessionsAdapter.Viewholder> {
    private final ArrayList<Lession> list;
    private Context context;

    public LessionsAdapter(ArrayList<Lession> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LessionsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        ViewholderExerciseBinding binding= ViewholderExerciseBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessionsAdapter.Viewholder holder, int position) {
        // Set the title and duration
        holder.binding.titleTxt.setText(list.get(position).getTitle());
        holder.binding.durationTxt.setText(list.get(position).getDuration());

        // Load the image with Glide
        int resId = context.getResources().getIdentifier(list.get(position).getPicPath(), "drawable", context.getPackageName());
        Glide.with(context)
                .load(resId)
                .into(holder.binding.pic);

        // Set click listener using getAdapterPosition()
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    // Use the current position to access the item
                    Lession currentLession = list.get(currentPosition);
                    Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + currentLession.getLink()));
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + currentLession.getLink()));

                    try {
                        context.startActivity(appIntent);
                    } catch (ActivityNotFoundException ex) {
                        context.startActivity(webIntent);
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderExerciseBinding binding;
        public Viewholder(ViewholderExerciseBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }
}
