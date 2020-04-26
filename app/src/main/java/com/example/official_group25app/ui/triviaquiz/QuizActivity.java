package com.example.official_group25app.ui.triviaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.official_group25app.R;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    //add in constant for timer countdown, 20 seconds each question
    private static final long COUNTDOWN_IN_MILLIS = 20000;
    //to access in main activity
    public static final String EXTRA_SCORE = "leaderBoard";
    //create variables
    private TextView tvQuestion;
    private TextView tvScore;
    private TextView tvQuestionCount;
    private TextView tvCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button btnnext;

    private ColorStateList textColorDefaultRb; //green or red depending on the answer

    //under 10sec turn red
    private ColorStateList textColourDefaultCD;
    private CountDownTimer countDownTimer;
    private long timeleft;


    private List<Question> questionList;
    private int questionCounter; //number of questions
    private int questionCountTotal; //total number of questions
    private Question currentQuestion;

    private int score;
    private boolean answered; //if answered or timed out

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tvQuestion = findViewById(R.id.tv_question);
        tvScore = findViewById(R.id.tv_score);
        tvQuestionCount = findViewById(R.id.tv_question_count);
        tvCountDown = findViewById(R.id.tv_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        btnnext = findViewById(R.id.btn_next);

        //https://www.youtube.com/watch?v=tlgrX3HF6AI reference for colour changing of radio buttons line 72 to 116
        textColorDefaultRb = rb1.getTextColors(); //RADIO BUTTON COLOR
        textColourDefaultCD = tvCountDown.getTextColors(); //countdown color

        //initialise QuizDBHelper class
        QuizDBHelper dbHelper = new QuizDBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList); //shuffle question list for gamifying effects

        showNextQuestion(); //method

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) { //if radio button not checked, then show toast error
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(QuizActivity.this, "Select answer", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    showNextQuestion();
                }
            }
        });

    }

    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);//set default colours of the radio buttons
        rb2.setTextColor(textColorDefaultRb);//set default colours of the radio buttons
        rb3.setTextColor(textColorDefaultRb);//set default colours of the radio buttons
        rbGroup.clearCheck(); //all radio buttons are unselected after question

        if (questionCounter < questionCountTotal) { //shuffle through the question list
            currentQuestion = questionList.get(questionCounter); //increment for next question

            tvQuestion.setText(currentQuestion.getQuestion()); //send to tvquestion object
            rb1.setText(currentQuestion.getChoice1());
            rb2.setText(currentQuestion.getChoice2());
            rb3.setText(currentQuestion.getChoice3());

            questionCounter++;
            tvQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false; //lock answer
            btnnext.setText("Confirm");

            timeleft = COUNTDOWN_IN_MILLIS;
            startCountDown(); //coutdown method
        } else { //if total < counter, quiz is finished, go back to main page
            finishQuiz();
        }
    }
    private void startCountDown(){
        //start countdown timer, reference https://www.youtube.com/watch?v=bLUXfWkZMD8&t=40s
        countDownTimer = new CountDownTimer(timeleft, 1000) { //count every 1000 milliseconds
            @Override
            public void onTick(long millisUntilFinished) { //milliseconds left until finished
                timeleft = millisUntilFinished;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                timeleft = 0;
                updateCountDown();
                checkAnswer();
            }
        }.start(); //start countdown after created
    }

    private void updateCountDown() {
        //add in the 20 seconds
        int minutes = (int) (timeleft / 1000) / 60;
        int seconds = (int) (timeleft / 1000) % 60; //only get what is left after dividing to avoid doublecounting the time in the minutes object

        String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds); //format
        tvCountDown.setText(time);

        //colour changes below 10 seconds
        if (timeleft < 10000) {
            tvCountDown.setTextColor(Color.RED);
        } else{
            tvCountDown.setTextColor(textColourDefaultCD);
        }
    }

    private void checkAnswer() { //per line 87 of code, create check answer method
        answered= true; //any radio button if checked is passed to rbSelected
        countDownTimer.cancel(); //after answer picked timer stop
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNumber = rbGroup.indexOfChild(rbSelected) + 1; //since starts at 0, correct answers either 1,2,3

        if (answerNumber == currentQuestion.getCorrectans()) { //compare to correct answer
            score++;
            tvScore.setText("Score: " + score); //new score stored

        }

        showSolution();
    }

    private void showSolution(){ //method created on line 170
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectans()) { //color changes depending on whether answer is correct
            case 1:
                rb1.setTextColor(Color.GREEN);
                tvQuestion.setText("Choice 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                tvQuestion.setText("Choice 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                tvQuestion.setText("Choice 3 is correct");
                break;


        } //go to next page if quiz is completed, otherwise finish quiz and leads back to start page
        if (questionCounter < questionCountTotal) {
            btnnext.setText("Next");
        }else {
            btnnext.setText("Finish");
        }
    }


    private void finishQuiz() { //define that the score value is sent back to leaderboard. https://www.youtube.com/watch?v=y1FxIOFuIAs 1.44 onwards

        Intent resultIntent = new Intent(getApplicationContext(), Result.class); //intent is created to send back result to leaderboard
        resultIntent.putExtra("leaderBoard", score); // pass value = score
        startActivity(resultIntent);


    }

    @Override //after activity finished, cancel countdown in background
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}

