package com.example.pulsefit.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.pulsefit.Adapter.LessionsAdapter;
import com.example.pulsefit.Domain.Workout;
import com.example.pulsefit.R;
import com.example.pulsefit.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity {
    ActivityWorkoutBinding binding;
    private Workout workout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityWorkoutBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_workout);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        
        getObject();
        setVariable();
    }

    private void getObject() {
        workout= (Workout) getIntent().getSerializableExtra("object");
    }

    private void setVariable() {
        int resId= getResources().getIdentifier(workout.getPicPath(), "drawable", getPackageName());
        Glide.with(this)
                .load(resId)
                .into(binding.pic);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.titleTxt.setText(workout.getTitle());
        binding.excerciseTxtid.setText(workout.getLessions().size()+" Exercise");
        binding.kcalTxtid.setText(workout.getKcal()+" Kcal");
        binding.durationid.setText(workout.getDuration());
        binding.descriptionTxt.setText(workout.getDescription());

        binding.view2.setLayoutManager(new LinearLayoutManager(WorkoutActivity.this, LinearLayoutManager.VERTICAL, false));
        binding.view2.setAdapter(new LessionsAdapter(workout.getLessions()));
    }
}