package com.example.official_group25app.ui.recipes.recipesAPI;


// This class was created by firstly creating an API request using "https://postwoman.io/".
// We then used the response generated from postwoman to convert JSON to Java Objects using "http://www.jsonschema2pojo.org/"
// We only kept the variables that were relevant to what we wanted to achieve - Retrieve recipe data that includes, title, servings, ready in minutes,
//instructions.

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class API {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("readyInMinutes")
    @Expose
    private Integer readyInMinutes;
    @SerializedName("servings")
    @Expose
    private Integer servings;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("imageType")
    @Expose
    private String imageType;

    @SerializedName("instructions")
    @Expose
    private String instructions;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }


    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
