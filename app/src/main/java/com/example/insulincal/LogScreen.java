package com.example.insulincal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.StrictMath;

import androidx.appcompat.app.AppCompatActivity;

public class LogScreen extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    Button barCodeButton;
    Button ManualInputButton;
    Button calButton;
    EditText bloodSugar;
    TextView totalCarbs;

    int insulin;
    int insulinRound;
    int carbRatio = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_screen_activity);

        Intent intent = getIntent();
        int CC = intent.getIntExtra("CarboCal", 0);
        String carb = String.valueOf(CC);


        barCodeButton = (Button) findViewById(R.id.scanBarcodeButton);
        barCodeButton.setOnClickListener(LogScreen.this);

        ManualInputButton = (Button) findViewById(R.id.manulInputButton);
        ManualInputButton.setOnClickListener(LogScreen.this);

        calButton = (Button) findViewById(R.id.calculateButton);
        calButton.setOnClickListener(LogScreen.this);

        bloodSugar = (EditText) findViewById(R.id.bloodSugarEditText);
        bloodSugar.setOnEditorActionListener(LogScreen.this);

        totalCarbs = (TextView) findViewById(R.id.loggedCarbsTotalTextView);
        totalCarbs.setText(carb);
    }

    @Override
    public void onClick(View view) {
        if (barCodeButton == view) {
            Intent intent = new Intent(this, barCodeScannerActivity.class);
            startActivity(intent);
        }

        if (ManualInputButton == view) {
            Intent intent = new Intent(this, manualInputActivity.class);
            startActivity(intent);
        }

        if (calButton == view) {
            if (bloodSugar.length() != 0 && totalCarbs.length() != 0) {
                try {
                    Log.v("EditText", bloodSugar.getText().toString());
                    Log.v("carbText", totalCarbs.getText().toString());
                    int c = Integer.valueOf(totalCarbs.getText().toString());
                    int s = Integer.valueOf(bloodSugar.getText().toString());
                    insulin = c / carbRatio;
                    Math.round(insulin);
                    insulin = insulinRound;

                    Intent intent = new Intent(LogScreen.this, recommendedInsulinActivity.class);
                    intent.putExtra("InsulinRounded",insulinRound);
                    startActivity(intent);

                    Intent intent2 = new Intent(LogScreen.this, recommendedInsulinActivity.class);
                    intent.putExtra("Sugar",s);
                    startActivity(intent2);

                    Intent intent3 = new Intent(LogScreen.this, recommendedInsulinActivity.class);
                    intent.putExtra("Carbs",c);
                    startActivity(intent3);

                    Intent myIntent = new Intent(this, recommendedInsulinActivity.class);
                    startActivity(myIntent);


                } catch (NumberFormatException nfe) {
                    System.out.println("Please Enter Numbers Only" + nfe);
                }
            } else {
                Toast.makeText(LogScreen.this, "Please Enter Blood Sugar Reading and input carbs", Toast.LENGTH_LONG).show();

            }
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {


        return false;
    }
}

