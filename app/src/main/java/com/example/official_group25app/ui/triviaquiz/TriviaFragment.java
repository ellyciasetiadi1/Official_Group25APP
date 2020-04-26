package com.example.official_group25app.ui.triviaquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.quiz.MainActivity;

import java.util.Objects;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

public class TriviaFragment extends Fragment {

    private TriviaViewModel triviaViewModel;
    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREFS = "shared_pref";
    public static final String KEY_LEADERBOARD = "leaderBoard";


    private TextView txtLeaderboard;
    private int highscore;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_triviaquiz, container, false);


        Button btnStartQuiz = view.findViewById(R.id.btn_start_quiz); //this is the button that starts the trivia quiz activity in QuizActivity.class


        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), com.example.official_group25app.ui.triviaquiz.QuizActivity.class));//intent is created to go from TriviaFragment to QuizActivity.class


            }
        });
        return view;
    }
}





