package com.example.official_group25app.ui.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.cuisines.French;
import com.example.official_group25app.ui.recipes.cuisines.Indian;
import com.example.official_group25app.ui.recipes.cuisines.Italian;
import com.example.official_group25app.ui.recipes.cuisines.Japanese;
import com.example.official_group25app.ui.recipes.cuisines.Korean;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class RecipesFragment extends Fragment {

    private Button japaneseButton;
    private Button italianButton;
    private Button indianButton;
    private Button koreanButton;
    private Button frenchButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        japaneseButton = view.findViewById(R.id.japaneseButton);
        italianButton = view.findViewById(R.id.italianButton);
        indianButton = view.findViewById(R.id.indianButton);
        koreanButton = view.findViewById(R.id.koreanButton);
        frenchButton = view.findViewById(R.id.frenchButton);


        //The user is provided with the option of selecting from 5 cuisines: Japanese, Italian, Indian,
        //Korean, French. To make a selection the user must click on the button. By using OnClickListener,
        // once the user clicks on the button it will execute the code written in onClick(View).
        // This will allow users to easily access the specific cuisine they have chosen. E.g. Italian

        /** Called when the user clicks on the "JAPANESE" button and will launch the user into
         * the Japanese.class activity **/

        japaneseButton.setOnClickListener(new View.OnClickListener() {

            //onClick determines what happens when the user clicks on the button
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), Japanese.class));

            }
        });


        /** Called when the user clicks on the "ITALIAN" button and will launch the user into
         * the Italian.class activity **/

        italianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), Italian.class));

            }
        });

        /** Called when the user clicks on the "INDIAN" button and will launch the user into
         * the Indian.class activity **/

        indianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), Indian.class));

            }
        });

        /** Called when the user clicks on the "KOREAN" button and will launch the user into
         * the Korean.class activity **/

        koreanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), Korean.class));

            }
        });

        /** Called when the user clicks on the "FRENCH" button and will launch the user into
         * the French.class activity **/

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), French.class));

            }
        });

        return view;

    }
}






