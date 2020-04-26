package com.example.official_group25app.ui.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.official_group25app.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = (TextView) findViewById(R.id.result);
        TextView totalScore = (TextView) findViewById(R.id.totalScore);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("quizApp", Context.MODE_PRIVATE); //save value in shared preferences based on CONSTANT name
        int total = settings.getInt("total", 0);
        total += score;

        result.setText(score + "/5");
        totalScore.setText("Total Score: " + total);

        //Update total score
        SharedPreferences.Editor editor = settings.edit();  //save variable "total" score in shared preferences
        editor.putInt("total", total); //replace total with new total score
        editor.commit();

    }

    //Once the user completes the quiz they are able to easily go back to the home screen by clicking on the button "return to home"
    //where they can see how their score gained from the quiz is added to the total score in the home screen.

    public void returnTop(View view){
        Intent intent = new Intent(getApplicationContext(), com.example.official_group25app.MainActivity.class);
        startActivity(intent);
    }

}

