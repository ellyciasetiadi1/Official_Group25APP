package com.example.official_group25app.ui.recipes.cuisines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.recipesAPI.Korean_1;
import com.example.official_group25app.ui.recipes.recipesAPI.Korean_2;
import com.example.official_group25app.ui.recipes.recipesAPI.Korean_3;
import com.example.official_group25app.ui.recipes.recipesAPI.Random_Korean;

public class Korean extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.group25app.MESSAGE";
    private Button korean1;
    private Button korean2, korean3,koreanRandom;
    private ImageView imageKorean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korean);

        korean1 = findViewById(R.id.korean1);
        korean2 = findViewById(R.id.korean2);
        korean3 = findViewById(R.id.korean3);
        koreanRandom = findViewById(R.id.koreanRandom);
        imageKorean = findViewById(R.id.imageKorean);


        korean1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                korean1ButtonLaunched("launch");

            }
        });

        korean2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                korean2ButtonLaunched("launch");

            }
        });

        korean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                korean3ButtonLaunched("launch");

            }
        });

        koreanRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                koreanRandomButtonLaunched("launch");

            }
        });

    }

    /** Called when the user clicks on the "RECIPE 1" button **/

    public void korean1ButtonLaunched(String message) {

        Intent intent = new Intent(this, Korean_1.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 2" button **/

    public void korean2ButtonLaunched(String message) {

        Intent intent = new Intent(this, Korean_2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 3" button **/

    public void korean3ButtonLaunched(String message) {

        Intent intent = new Intent(this, Korean_3.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "DESSERT" button **/

    public void koreanRandomButtonLaunched(String message) {

        Intent intent = new Intent(this, Random_Korean.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

