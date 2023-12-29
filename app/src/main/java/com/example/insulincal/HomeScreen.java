package com.example.insulincal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    Button logMealButton;
    Button personalHealthButton;
    Button logHistoryButton;
    Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        logMealButton = (Button) findViewById(R.id.logMealButton);
        logMealButton.setOnClickListener(HomeScreen.this);

        personalHealthButton = (Button) findViewById(R.id.personalHealthButton);
        personalHealthButton.setOnClickListener(HomeScreen.this);

        logHistoryButton = (Button) findViewById(R.id.logHistoryButton);
        logHistoryButton.setOnClickListener(HomeScreen.this);

        settingsButton = (Button) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(HomeScreen.this);

    }


    @Override
    public void onClick(View view) {

        if (view == logMealButton) {
            Intent intent = new Intent(this, LogScreen.class);
            startActivity(intent);
        }

        if(view == personalHealthButton){
            Intent intent = new Intent(this, PersonalHealthInfo.class);
            startActivity(intent);
        }

        if (view == logHistoryButton){
            Intent intent = new Intent(this, logHistory.class);
            startActivity(intent);
        }

        if(view == settingsButton){
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        }
    }
}