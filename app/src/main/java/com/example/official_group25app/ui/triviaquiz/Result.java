package com.example.official_group25app.ui.triviaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.recipesAPI.French_1;


public class Result extends AppCompatActivity {

    private TextView totalScore1;
    private Button buttonBackHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        TextView totalScore1 = findViewById(R.id.totalScore1);
        final Button buttonBackHome = findViewById(R.id.buttonBackHome);


        int score = getIntent().getIntExtra("leaderBoard", 0);
        SharedPreferences prefs = getSharedPreferences("shared_pref", Context.MODE_PRIVATE); //save value in shared preferences based on CONSTANT name
        int total1 = prefs.getInt("total1", 0);
        total1 += score;

        totalScore1.setText("Total Score: " + total1);

        //Update total score
        SharedPreferences.Editor editor = prefs.edit(); // save variable leaderboard score in shared preferences
        editor.putInt("total1", total1); //replace leaderboard with new score
        editor.commit();


        buttonBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buttonBackHomeLaunched();

            }
        });

    }

    public void buttonBackHomeLaunched() {

        Intent intent = new Intent(this,com.example.official_group25app.MainActivity.class);
        startActivity(intent);

    }
}

