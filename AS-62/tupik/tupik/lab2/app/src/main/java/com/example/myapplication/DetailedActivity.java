package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {
ActivityDetailedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int ingredients = intent.getIntExtra("ingredients",R.string.maggiIngredients);
            int desc = intent.getIntExtra("desc",R.string.maggiDesc);
            int image = intent.getIntExtra("image",R.drawable.picture0);
            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
    }
}