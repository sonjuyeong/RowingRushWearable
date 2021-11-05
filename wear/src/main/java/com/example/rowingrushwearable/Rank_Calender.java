package com.example.rowingrushwearable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Rank_Calender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rank_calender);


    }


    public void calender(View view) {

        startActivity(new Intent(this, MainActivity.class));

    }

    public void ranking(View view) {
        startActivity(new Intent(this, DistanceActivity.class));
    }
}
