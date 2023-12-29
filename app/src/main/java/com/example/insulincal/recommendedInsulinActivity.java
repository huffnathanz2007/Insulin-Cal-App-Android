package com.example.insulincal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class recommendedInsulinActivity extends AppCompatActivity implements View.OnClickListener {

    Button doneButton;
    TextView informativeText;
    TextView insulinT;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_insulin);

        doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(recommendedInsulinActivity.this);

        Intent intent = getIntent();
        int insulin = intent.getIntExtra("InsulinRounded", 0);
        String insulinText = String.valueOf(insulin);

        Intent intent3 = getIntent();
        int carbs = intent3.getIntExtra("Carbs", 0);
        ;

        Intent intent2 = getIntent();
        int bloodSugar = intent2.getIntExtra("Sugar", 0);
        String bloodSugarText = String.valueOf(bloodSugar);

        informativeText = (TextView)findViewById(R.id.infomativeText);
        informativeText.setText("The recommend Units of insulin with eating "+carbs+" carbs and current blood sugar of " +bloodSugar+" is: ");

        insulinT = (TextView)findViewById(R.id.insulinUnitTextView);
        insulinT.setText(""+insulin+ "CC Units of insulin" );

        info = (TextView) findViewById(R.id.infoTextView2);
        info.setText("please remember to eat the meal you just corrected for within 15 minutes of completing your insulin injection to help prevent low blood sugar");


    }

    @Override
       public void onClick(View view){

        if (view == doneButton) {
            Intent intent = new Intent(this, HomeScreen.class);
            startActivity(intent);
        }

       }
}