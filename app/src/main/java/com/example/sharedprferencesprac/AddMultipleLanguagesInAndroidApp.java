package com.example.sharedprferencesprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.sharedprferencesprac.databinding.ActivityAddMultipleLanguagesInAndroidAppBinding;

public class AddMultipleLanguagesInAndroidApp extends AppCompatActivity {

    ActivityAddMultipleLanguagesInAndroidAppBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityAddMultipleLanguagesInAndroidAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage();
            }
        });

    }

    private void changeLanguage() {


    }
}