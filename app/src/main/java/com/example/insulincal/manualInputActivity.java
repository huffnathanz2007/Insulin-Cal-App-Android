package com.example.insulincal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class manualInputActivity extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener {

    EditText totalCarbs;
    EditText totalFiber;
    EditText totalSugar;
    Button Add;
    int CarboCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_input);

        totalCarbs = (EditText) findViewById(R.id.totalCarbEditText);
        totalCarbs.setOnEditorActionListener(manualInputActivity.this);

        totalFiber = (EditText) findViewById(R.id.fiberEditText);
        totalFiber.setOnEditorActionListener(manualInputActivity.this);

        totalSugar = (EditText) findViewById(R.id.alcholSugEditText);
        totalSugar.setOnEditorActionListener(manualInputActivity.this);

        Add = (Button) findViewById(R.id.addButtonInput);
        Add.setOnClickListener(manualInputActivity.this);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {



        return false;
    }

    @Override
    public void onClick(View view){
        if (totalSugar.length()!= 0 && totalFiber.length()!=0 && totalCarbs.length()!=0){
            Log.v("EditText", totalCarbs.getText().toString());
            Log.v("EditText", totalFiber.getText().toString());
            Log.v("EditText", totalSugar.getText().toString());

            int C = Integer.valueOf(totalCarbs.getText().toString());
            int F = Integer.valueOf(totalFiber.getText().toString());
            int S = Integer.valueOf(totalSugar.getText().toString());

            CarboCal = C - (F+S);

            Intent intent = new Intent(manualInputActivity.this, LogScreen.class);
            intent.putExtra("CarboCal",CarboCal);
            startActivity(intent);

            return;

        }

        else
        {
            Toast.makeText(manualInputActivity.this, "Please make sure you fill out Carbs, Fiber, and Alcohol Sugar", Toast.LENGTH_LONG).show();
        }

    }
}