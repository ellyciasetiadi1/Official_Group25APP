package com.example.official_group25app.ui.recipes.cuisines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.recipesAPI.Italian_1;
import com.example.official_group25app.ui.recipes.recipesAPI.Italian_2;
import com.example.official_group25app.ui.recipes.recipesAPI.Italian_3;
import com.example.official_group25app.ui.recipes.recipesAPI.Random_Italian;

public class Italian extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.official_group25app.MESSAGE";
    private Button italian1;
    private Button italian2, italian3, italianRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian);

        italian1 = findViewById(R.id.italian1);
        italian2 = findViewById(R.id.italian2);
        italian3 = findViewById(R.id.italian3);
        italianRandom = findViewById(R.id.italianRandom);


        italian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                italian1ButtonLaunched("launch");

            }
        });

        italian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                italian2ButtonLaunched("launch");

            }
        });

        italian3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                italian3ButtonLaunched("launch");

            }
        });

        italianRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                italianRandomButtonLaunched("launch");

            }
        });

    }

    /** Called when the user clicks on the "RECIPE 1" button **/

    public void italian1ButtonLaunched(String message) {

        Intent intent = new Intent(this, Italian_1.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 2" button **/

    public void italian2ButtonLaunched(String message) {

        Intent intent = new Intent(this, Italian_2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 3" button **/

    public void italian3ButtonLaunched(String message) {

        Intent intent = new Intent(this, Italian_3.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "DESSERT" button **/

    public void italianRandomButtonLaunched(String message) {

        Intent intent = new Intent(this, Random_Italian.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}

