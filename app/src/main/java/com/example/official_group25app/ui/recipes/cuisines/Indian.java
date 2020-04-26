package com.example.official_group25app.ui.recipes.cuisines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.recipesAPI.Indian_1;
import com.example.official_group25app.ui.recipes.recipesAPI.Indian_2;
import com.example.official_group25app.ui.recipes.recipesAPI.Indian_3;
import com.example.official_group25app.ui.recipes.recipesAPI.Random_Indian;

public class Indian extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.official_group25app.MESSAGE";
    private Button indian1;
    private Button indian2, indian3, indianRandom;
    private ImageView imageIndian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian);

        indian1 = findViewById(R.id.indian1);
        indian2 = findViewById(R.id.indian2);
        indian3 = findViewById(R.id.indian3);
        indianRandom = findViewById(R.id.indianRandom);
        imageIndian = findViewById(R.id.imageIndian);


        indian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                indian1ButtonLaunched("launch");

            }
        });

        indian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                indian2ButtonLaunched("launch");

            }
        });

        indian3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                indian3ButtonLaunched("launch");

            }
        });

        indianRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                indianRandomButtonLaunched("launch");

            }
        });

    }

    /** Called when the user clicks on the "RECIPE 1" button **/

    public void indian1ButtonLaunched(String message) {

        Intent intent = new Intent(this, Indian_1.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 2" button **/

    public void indian2ButtonLaunched(String message) {

        Intent intent = new Intent(this, Indian_2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 3" button **/

    public void indian3ButtonLaunched(String message) {

        Intent intent = new Intent(this, Indian_3.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "DESSERT" button **/

    public void indianRandomButtonLaunched(String message) {

        Intent intent = new Intent(this, Random_Indian.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

