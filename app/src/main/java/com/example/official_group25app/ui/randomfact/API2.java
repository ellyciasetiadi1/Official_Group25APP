package com.example.official_group25app.ui.randomfact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// This class was created by firstly creating an API request using "https://postwoman.io/".
// We then used the response generated from postwoman to convert JSON to Java Objects using "http://www.jsonschema2pojo.org/"
// We only kept the variables that were relevant to what we wanted to achieve - Retrieve random food fact data.

public class API2 {

    @SerializedName("text")
    @Expose
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
