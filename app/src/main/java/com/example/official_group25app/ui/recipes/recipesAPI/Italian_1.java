package com.example.official_group25app.ui.recipes.recipesAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.official_group25app.R;
import com.example.official_group25app.ui.recipes.cuisines.Japanese;
import com.google.gson.Gson;

/* ScrollView was incorporated because we found that the instructions of the recipes were too long to fit the screen. Therefore, scrollView allowed us to
be able to show all the recipe information in a user-friendly one single scroll feature. We learnt how to implement ScrollView via:
https://www.youtube.com/watch?v=_IF1vJF7Xb8 at 0:53 - 2:16. We were then inspired by the video to use a linear layout and not a constraint layout because
we found that the TextView features kept jumping around the page and did not hold its place. Linear Layout provided us with the clean and
easy structure we currently have to view recipe information.
*/

public class Italian_1 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.group25app.MESSAGE";
    private TextView italian1Title;
    private TextView italian1Ready;
    private TextView italian1Servings;
    private ImageView italian1Image;
    private TextView italian1Instructions;

    // The URL link used to retrieve API data is from Spoonacular
    String URL = "https://api.spoonacular.com/recipes/695539/information?includeNutrition=false&apiKey=1c3106a2562b46c6b0e545f70a9252b8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_1);

        italian1Title = findViewById(R.id.italian1Title);
        italian1Ready = findViewById(R.id.italian1Ready);
        italian1Servings = findViewById(R.id.italian1Servings);
        italian1Image = findViewById(R.id.italian1Image);
        italian1Instructions = findViewById(R.id.italian1Instructions);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Japanese.EXTRA_MESSAGE);

        /* Having learnt RetroFit in the tutorial, we wanted to go beyond what was taught and use Volley to manage our
        network requests. We learnt the Volley.newRequestQueue method via: https://developer.android.com/training/volley/simple. Where
        we learnt how to set up a RequestQueue, and start the queue, whilst we customised it to our own values to receive the specific data from
        Spoonacular API. E.g. Recipe title, servings, ready in minutes, instructions.

        */

        // This creates a request queue
        // Volley is essentially a HTTP library that we chose to use because it makes networking for Android apps
        //easier and faster. This library is used to transmit data over the network.
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        // This constructs the request queue and handles the response
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, URL,

                //Where the data will go after the request is successfully complete
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("CODE", response);

                        //Gson has been used here to convert Java objects to match JSON constructs. The Gson library
                        // has ultimately been used to load the recipe details from the Spoonacular API.
                        Gson gson = new Gson();
                        API results = gson.fromJson(String.valueOf(response), API.class);

                        String setTitle = results.getTitle();
                        Integer setServings = results.getServings();
                        Integer setReady = results.getReadyInMinutes();
                        String setInstructions = results.getInstructions();



                        italian1Title.setText(setTitle);
                        italian1Servings.setText(String.valueOf(setServings));
                        italian1Ready.setText(String.valueOf(setReady));
                        italian1Instructions.setText(setInstructions);
                        italian1Image.setImageResource(R.drawable.italian_1);


                        // What will be returned if there was a problem with the request
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

                // Add request to the RequestQueue
            }

        });
        requestQueue.add(stringRequest);

    }
}
