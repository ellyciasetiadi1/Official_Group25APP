package com.example.official_group25app.ui.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.official_group25app.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView count;
    private TextView question;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ImageView progressImage;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    //create questions and answer choices for each cuisine category
    //array format {"Question", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}
    String quizJapanese[][] = {
            {"What are soba noodles made out of?", "Buckwheat flour", "Agar", "Wheat", "Potato Starch"},
            {"Yuzu is a type of what?", "Citrus", "Soup", "Noodle", "Fish"},
            {"Where does wasabi come from?", "Plant Root", "Ocean", "Leaves", "Berry Seed"},
            {"What is unagi?", "Freshwater Eel", "Soy Sauce", "Rice", "Pork"},
            {"Mochi is a type of what?", "Confectionary", "Bread", "Pancake", "Sweet Paste"},
            {"What ingredient is not in dashi?", "Miso", "Water", "Kombu", "Bonito Flakes"}
    };

    String quizItalian[][] = {
            {"What is a piadina?", "Flatbread", "Potato Dumpling", "Cornmeal Cake", "Pasta"},
            {"Which is not a stuffed pasta?", "Capellini", "Manicotti", "Agnolotti", "Fagottini"},
            {"What ingredient is not in puttanesca sauce?", "Bell pepper", "Capers", "Anchovies", "Garlic"},
            {"What is bow tie pasta called?", "Farfalle", "Linguine", "Penne", "Cannelloni"},
            {"What ingredient is not found in pesto?", "Green olives", "Basil", "Pine nuts", "Olive oil"},
            {"What ingredient is not in pizza margherita?", "Balsamic", "Basil", "Tomato", "Mozzarella"},
            {"What is guanciale?", "Pork jowl", "Pasta shape", "Cured Fish", "Vinegar Sauce"}
    };

    String quizKorean[][] = {
            {"What is kimchi made of?", "Cabbage", "Rice", "Noodles", "Asparagus"},
            {"What does bulgolgi literally mean?", "Fire meat", "Spicy meat", "Soft meat", "Sweet meat"},
            {"What are Korean side dishes called?", "Banchan", "Bap", "Moksal", "Guksoo"},
            {"What noodle dish is primary eaten in summer?", "Mul Naengmyeon", "Japchae", "Ramyeon", "Kalguksu"},
            {"What's the Korean name for dumplings?", "Mandoo", "Japchae", "Ramyun", "Tapioca"},
            {"What is done to bibimbap?", "Mixed", "Wrapped", "Frozen", "Grilled"}
    };

    String quizIndian[][] = {
            {"What's in masala dosa?", "Potatoes", "Chickpeas", "Chicken", "Fish"},
            {"Which do you find in mattar paneer?", "Peas", "Chickpeas", "Kidney beans", "Lentils"},
            {"What meat is vindaloo served with?", "Pork", "Chicken", "Beef", "No meat"},
            {"What is India's national fruit?", "Mango", "Durian", "Lychee", "Jackfruit"},
            {"What word is used in India for tea?", "Chai", "Za", "Ocha", "Cha"},
            {"Rogan Josh is a staple of which Indian cuisine?", "Kashmiri", "Punjabi", "Gujarati", "Rajasthani"},
            {"Which isn't a type of Indian bread?", "Paneer", "Roti", "Naan", "Paratha"}
    };

    String quizFrench[][] = {
            {"What stage of a meal would you eat a Charlotte?", "Dessert", "Entree", "Appetizer", "Main"},
            {"What is Coquille St. Jacques?", "Scallops", "Tuna", "Sea Urchin", "Mussel"},
            {"What region of France is the original home of Calvados?", "Normandy", "Brittany", "Picardy", "Auvergne"},
            {"Frappe refers to something that is?", "Iced or Chilled", "Whipped", "Chopped", "Sweetened"},
            {"Tournedos are created from what type of meat?", "Beef", "Pork", "Veal", "Chicken"},
            {"Crudties are a selection of raw what?", "Vegetables", "Fruits", "Meats", "Fish"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        count = (TextView)findViewById(R.id.count);
        question =(TextView)findViewById(R.id.question);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        //Receive quizCategory from startActivity
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);

        Log.v("CATEGORY_TAG", quizCategory + "");

        //Create quiz array from data
        if (quizCategory == 1) {
            for (int i = 0; i < quizJapanese.length; i++) {
                //Prepare array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizJapanese[i][0]); //Question
                tmpArray.add(quizJapanese[i][1]); //Right answer
                tmpArray.add(quizJapanese[i][2]); //Choice 1
                tmpArray.add(quizJapanese[i][3]); //choice 2
                tmpArray.add(quizJapanese[i][4]); //choice 3

                //Add tmpArray to quizArray
                quizArray.add(tmpArray);
            }
        } else if (quizCategory == 2){
            for (int i = 0; i < quizItalian.length; i++) {
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizItalian[i][0]); //Question
                tmpArray.add(quizItalian[i][1]); //Right answer
                tmpArray.add(quizItalian[i][2]); //Choice 1
                tmpArray.add(quizItalian[i][3]); //choice 2
                tmpArray.add(quizItalian[i][4]); //choice 3

                quizArray.add(tmpArray);
            }
        } else if (quizCategory == 3){
            for (int i = 0; i < quizKorean.length; i++) {
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizKorean[i][0]); //Question
                tmpArray.add(quizKorean[i][1]); //Right answer
                tmpArray.add(quizKorean[i][2]); //Choice 1
                tmpArray.add(quizKorean[i][3]); //choice 2
                tmpArray.add(quizKorean[i][4]); //choice 3

                quizArray.add(tmpArray);
            }
        } else if (quizCategory == 4){
            for (int i = 0; i < quizIndian.length; i++) {
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizIndian[i][0]); //Question
                tmpArray.add(quizIndian[i][1]); //Right answer
                tmpArray.add(quizIndian[i][2]); //Choice 1
                tmpArray.add(quizIndian[i][3]); //choice 2
                tmpArray.add(quizIndian[i][4]); //choice 3

                quizArray.add(tmpArray);
            }
        } else if (quizCategory == 5){
            for (int i = 0; i < quizFrench.length; i++) {
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizFrench[i][0]); //Question
                tmpArray.add(quizFrench[i][1]); //Right answer
                tmpArray.add(quizFrench[i][2]); //Choice 1
                tmpArray.add(quizFrench[i][3]); //choice 2
                tmpArray.add(quizFrench[i][4]); //choice 3

                quizArray.add(tmpArray);
            }
        }

        showNextQuiz();

    }

    // Referencing https://www.youtube.com/watch?v=aUQ9ciMDPSE for lines 168-196. Through the video, we learnt how to set the question and answer
    //from the array of different questions.

    public void showNextQuiz(){
        //Update quiz question number label
        count.setText("Q" + quizCount);

        //Generate random number between 0 and 5 (quizArray's size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //Pick a quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        //Set q and answer, with array format {"Question", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}
        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        //Remove question from quiz
        quiz.remove(0);
        Collections.shuffle(quiz);

        //Set choices
        button1.setText(quiz.get(0));
        button2.setText(quiz.get(1));
        button3.setText(quiz.get(2));
        button4.setText(quiz.get(3));

        //Remove from quizArray
        quizArray.remove(randomNum);

    }

    //Referencing via https://www.youtube.com/watch?v=AH3SQOMEgZk for lines 200-239. Through the video we learnt how to set up
    //a feedback dialogue for users so that there is a user-friendly pop up screen notifying when the user selects the correct
    //answer or the wrong answer.

    public void checkAnswer(View view){

        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;
        progressImage = (ImageView)findViewById(R.id.progressBar);

        if (btnText.equals(rightAnswer)){
            //Correct
            alertTitle = "Correct!";
            rightAnswerCount++;

            //The if-else statement was also used as the answers selected by the user were binary (RIGHT/WRONG)
            //if the if-else method was unsatisfied with what was selected it would not allow a new progress bar to be shown
            //Update progress bar image based on their number of right answers
            //If an answer is wrong, the progress bar does not increase
            if(rightAnswerCount == 1){
                progressImage.setImageResource(R.drawable.progress_1);
            } else if(rightAnswerCount == 2){
                progressImage.setImageResource(R.drawable.progress_2);
            } else if(rightAnswerCount == 3){
                progressImage.setImageResource(R.drawable.progress_3);
            } else if(rightAnswerCount == 4){
                progressImage.setImageResource(R.drawable.progress_4);
            } else if(rightAnswerCount == 5){
                progressImage.setImageResource(R.drawable.progress_5);
            } else {
                progressImage.setImageResource(R.drawable.progress_0);
            }

        } else {
            //Wrong
            alertTitle = "Incorrect";
        }

        //Create answer dialogue
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Correct answer is: " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (quizCount == QUIZ_COUNT){
                    //Show result
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    startActivity(intent);

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
    }




