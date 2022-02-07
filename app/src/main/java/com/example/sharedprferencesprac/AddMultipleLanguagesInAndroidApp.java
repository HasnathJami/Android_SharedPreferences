package com.example.sharedprferencesprac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.sharedprferencesprac.databinding.ActivityAddMultipleLanguagesInAndroidAppBinding;

import java.util.Locale;

public class AddMultipleLanguagesInAndroidApp extends AppCompatActivity {

    ActivityAddMultipleLanguagesInAndroidAppBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ;
        super.onCreate(savedInstanceState);
        loadLocale();

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

         final String languages[]={"English","Bangla","Hindi"};

        AlertDialog.Builder mBuilder=new AlertDialog.Builder(this);
        mBuilder.setTitle("Choose A Language");
        mBuilder.setSingleChoiceItems(languages, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int selectIndex) {
                    if(selectIndex==0)
                    {
                        setLocale("");
                        recreate();
                    }
                if (selectIndex == 1) {
                    setLocale("bn");
                    recreate();
                }
                if (selectIndex == 2) {
                    setLocale("hi");
                    recreate();
                }
            }
        });

        mBuilder.create();
        mBuilder.show();

    }

    private void setLocale(String language) {

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration=new Configuration();
        configuration.locale=locale;

        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());


        //SharedPreferences sharedPreferences=getSharedPreferences("pref",MODE_PRIVATE);
        //SharedPreferences.Editor editor= sharedPreferences.edit();
        SharedPreferences.Editor editor=getSharedPreferences("setting",MODE_PRIVATE).edit();
        editor.putString("apple",language);
        editor.apply();

    }

    private void loadLocale()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("setting",MODE_PRIVATE);
        String receive=sharedPreferences.getString("apple","");
        setLocale(receive);
    }


}