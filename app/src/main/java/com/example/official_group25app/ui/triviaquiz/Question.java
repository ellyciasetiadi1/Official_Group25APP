package com.example.official_group25app.ui.triviaquiz;

public class Question {//this class contain information for question, answer choices, and answer
//bridge between the app and the database

    private String question;
    private String choice1; //Multiple choice A
    private String choice2; // Multiple choice B
    private String choice3; //Multiple choice C
    private int correctans; //this is an integer so that e.g if option A is correct, pass in int 1

      // when you query data from database, create empty question object, use setter methods to
     //set value to the objects below
    // getter values to get values out of the object below

    public Question() {}

    //need to create a constructor to pass the 5 values when the objects are created

    public Question(String question, String choice1, String choice2, String choice3, int correctans) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.correctans = correctans;
    }
    //getter and setter methods are used to change values and get values out of the Question object to display

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getCorrectans() {
        return correctans;
    }

    public void setCorrectans(int correctans) {
        this.correctans = correctans;
    }
}

