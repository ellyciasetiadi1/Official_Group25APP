package com.example.official_group25app.ui.randomfact;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.official_group25app.R;
import com.google.gson.Gson;

public class RandomFactFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "com.example.group25app.MESSAGE";
    private Button randomButton;
    private TextView randomText;
    private ImageView randomImage;

    // The URL link used to retrieve API data is from Spoonacular
    String URL = "https://api.spoonacular.com/food/trivia/random?apiKey=1c3106a2562b46c6b0e545f70a9252b8";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_random, container, false);

        randomButton = view.findViewById(R.id.randomButton);
        randomText = view.findViewById(R.id.randomText);
        randomImage = view.findViewById(R.id.randomImage);


        // When the user clicks on the "NEW FACT" button this will trigger the randomFactCall() method and ultimately instantiates
        //the RequestQueue.
        randomButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /* Having learnt RetroFit in the tutorial, we wanted to go beyond what was taught and use Volley to manage our
        network requests. We learnt the Volley.newRequestQueue method via: https://developer.android.com/training/volley/simple. Where
        we learnt how to set up a RequestQueue, and start the queue, whilst we customised it to our own values to receive the specific data from
        Spoonacular API. E.g. Random Food Fact Text.

        */
                // This creates a request queue
                // Volley is essentially a HTTP library that we chose to use because it makes networking for Android apps
                //easier and faster. This library is used to transmit data over the network.
                final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

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
                                API2 results = gson.fromJson(String.valueOf(response), API2.class);

                                String setRandomText = results.getText();


                                randomText.setText(setRandomText);


                                // What will be returned if there was a problem with the request
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                        // Add request to the RequestQueue
                    }

                });
                requestQueue.add(stringRequest);
            }});
        return view;
    }
}