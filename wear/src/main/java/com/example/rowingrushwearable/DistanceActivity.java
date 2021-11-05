package com.example.rowingrushwearable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DistanceActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);


    }



    public void one(View view) {
        startActivity(new Intent(this, RankingActivity.class));
    }

    public void three(View view) {
       startActivity(new Intent(this, RankingActivity3.class));
    }

    public void five(View view) {
        startActivity(new Intent(this, RankingActivity5.class));
    }


}

