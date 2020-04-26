package com.example.official_group25app.ui.recipes.cuisines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.recipesAPI.French_1;
import com.example.official_group25app.ui.recipes.recipesAPI.French_2;
import com.example.official_group25app.ui.recipes.recipesAPI.French_3;
import com.example.official_group25app.ui.recipes.recipesAPI.Random_French;

public class French extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.official_group25app.MESSAGE";
    private Button french1;
    private Button french2, french3, frenchRandom;
    private ImageView imageFrench;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);

        french1 = findViewById(R.id.french1);
        french2 = findViewById(R.id.french2);
        french3 = findViewById(R.id.french3);
        frenchRandom = findViewById(R.id.frenchRandom);
        imageFrench =findViewById(R.id.imageFrench);


        french1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                french1ButtonLaunched("launch");

            }
        });

        french2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                french2ButtonLaunched("launch");

            }
        });

        french3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                french3ButtonLaunched("launch");

            }
        });

        frenchRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frenchRandomButtonLaunched("launch");

            }
        });

    }

    /** Called when the user clicks on the "RECIPE 1" button **/

    public void french1ButtonLaunched(String message) {

        Intent intent = new Intent(this, French_1.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 2" button **/

    public void french2ButtonLaunched(String message) {

        Intent intent = new Intent(this, French_2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 3" button **/

    public void french3ButtonLaunched(String message) {

        Intent intent = new Intent(this, French_3.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "DESSERT " button **/

    public void frenchRandomButtonLaunched(String message) {

        Intent intent = new Intent(this, Random_French.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

