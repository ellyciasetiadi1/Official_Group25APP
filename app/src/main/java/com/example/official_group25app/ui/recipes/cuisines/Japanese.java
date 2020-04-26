package com.example.official_group25app.ui.recipes.cuisines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.recipesAPI.Japanese_1;
import com.example.official_group25app.ui.recipes.recipesAPI.Japanese_2;
import com.example.official_group25app.ui.recipes.recipesAPI.Japanese_3;
import com.example.official_group25app.ui.recipes.recipesAPI.Random_Japanese;

public class Japanese extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.official_group25app.MESSAGE";
    private Button jap1;
    private Button jap2, jap3,japaneseRandom;
    private ImageView imageJapanese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese);

        jap3 = findViewById(R.id.jap3);
        jap1 = findViewById(R.id.jap1);
        jap2 = findViewById(R.id.jap2);
        japaneseRandom = findViewById(R.id.japaneseRandom);
        imageJapanese = findViewById(R.id.imageJapanese);



        jap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jap1ButtonLaunched("launch");

            }
        });

        jap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jap2ButtonLaunched("launch");

            }
        });

        jap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jap3ButtonLaunched("launch");

            }
        });

        japaneseRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                japaneseRandomButtonLaunched("launch");

            }
        });

    }

    /** Called when the user clicks on the "RECIPE 1" button **/

    public void jap1ButtonLaunched(String message) {

        Intent intent = new Intent(this, Japanese_1.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 2" button **/

    public void jap2ButtonLaunched(String message) {

        Intent intent = new Intent(this, Japanese_2.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "RECIPE 3" button **/

    public void jap3ButtonLaunched(String message) {

        Intent intent = new Intent(this, Japanese_3.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks on the "DESSERT" button **/

    public void japaneseRandomButtonLaunched(String message) {

        Intent intent = new Intent(this, Random_Japanese.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}

