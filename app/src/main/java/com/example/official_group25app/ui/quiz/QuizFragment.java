package com.example.official_group25app.ui.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.cuisines.Italian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        Button japanese = view.findViewById(R.id.japanese);
        Button italian = view.findViewById(R.id.italian);
        Button indian = view.findViewById(R.id.indian);
        Button korean = view.findViewById(R.id.korean);
        Button french = view.findViewById(R.id.french);


    /* When the user clicks on a cuisine to be quizzed on (Italian, French, Japanese, etc). This code
    will recognise what the user has clicked and take them to the specific cuisine quiz they have chosen.
    Through "intent.putExtra("QUIZ_CATEGORY, 1")"this will take them to "QUIZ_CATEGORY" in ui.quiz. MainActivity.class
    and whatever number is attached at the end, will be associated to a specific quiz category. E.g. 1 = Japanese,
    2 = Italian, 3 = Korean, 4 = Indian, 5 = French.

     */

        japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*We learnt how to send data from Fragment to Activity via: https://stackoverflow.com/questions/16036572/how-to-pass-values-between-fragments.
                Prior to adding "getBaseContext()" we only had getActivity(), MainActivity.class" and this did not allow the user to click on the buttons. Therefore
                after putting in "getBaseContext()" this allowed the user be able to select the buttons and be directed to the correct cuisine quiz
                of their choice.

                 */


                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("QUIZ_CATEGORY", 1);
                startActivity(intent);
            }
        });


        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("QUIZ_CATEGORY", 2);
                startActivity(intent);
            }
        });

        indian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("QUIZ_CATEGORY", 4);
                startActivity(intent);
            }
        });

        korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("QUIZ_CATEGORY", 3);
                startActivity(intent);
            }
        });

        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("QUIZ_CATEGORY", 5);
                startActivity(intent);
            }
        });

        return view;

    }
}



