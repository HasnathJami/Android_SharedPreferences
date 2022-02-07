package com.example.sharedprferencesprac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedprferencesprac.databinding.ActivitySharedPreferencesBasicBinding;

public class SharedPreferencesBasic extends AppCompatActivity {

    ActivitySharedPreferencesBasicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivitySharedPreferencesBasicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 binding.textView.setText(binding.editTextTextId.getText().toString());
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("text",binding.editTextTextId.getText().toString());
                editor.putBoolean("switch",binding.switch1.isChecked());
                editor.apply();
                Toast.makeText(SharedPreferencesBasic.this, "Data is saved", Toast.LENGTH_SHORT).show();
                }

        });

        onLoad();


    }

    private void onLoad()
    {
        SharedPreferences preferences=getSharedPreferences("pref",MODE_PRIVATE);
        String text= preferences.getString("text","");
        Boolean switchOnOff=preferences.getBoolean("switch",false);

        binding.textView.setText(text);
        binding.switch1.setChecked(switchOnOff);

    }
}