package com.example.official_group25app.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.official_group25app.R;

/* We originally had created an app using an "Empty Activity" layout. We would have all our key functions/destinations (Recipes, Quiz, Trivia Quiz,
Random Fact) as Button Intents in the home screen. We found this extremely inefficient because once the user finishes an activity,
E.g. A quiz, there was no easy way to return back to the home screen or any other activity other than to click the back button or exit the app completely and start again.
Therefore, we did a "Bottom Navigation Activity" layout that provided us with the bottom navigation menu you see within our app "bottom_nav_menu.xml and mobile_navigation.xml".
Bottom Navigation bar makes it easier for users to explore and switch between top-level views in a single tap. It was perfect for us to use since we have 5 top-level destinations
including the home screen. Although the Bottom Navigation Activity automatically provided us with the menu and navigation structure, We needed to learn how to set the
bottom navigation menu properly so that when you click a certain activity it goes to the correct activity, we watched: https://www.youtube.com/watch?v=tPV8xA7m-iw.
From 2:30 - 16:06.

*/


public class HomeFragment extends Fragment {

    private Button RecipesButton;
    private Button TriviaButton;
    private Button QuizButton;
    private Button RandomFoodButton;
    private ImageView home;

    private TextView totalScore;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView totalScore = view.findViewById(R.id.totalScore);

        int score = getActivity().getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        SharedPreferences settings = getActivity().getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int total = settings.getInt("total", 0);
        total += score;

        int score1 = getActivity().getIntent().getIntExtra("leaderBoard", 0);
        SharedPreferences prefs = getActivity().getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        int total1 = prefs.getInt("total1", 0);
        total1 += score;

        int userTotal = total + total1; // In order to get the user's total score accumulated from points score in both "quiz" + "trivia quiz"


        totalScore.setText("Total Score: " + userTotal);

        //Update total score
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("total", total);
        editor.commit();


        //Update total score
        SharedPreferences.Editor editor1 = prefs.edit();
        editor.putInt("total1", total1);
        editor.commit();




        return view;
    }}

