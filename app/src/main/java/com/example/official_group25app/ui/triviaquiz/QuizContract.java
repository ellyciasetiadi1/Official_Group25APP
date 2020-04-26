package com.example.official_group25app.ui.triviaquiz;

import android.provider.BaseColumns;

//youtube reference https://www.youtube.com/watch?v=qTGAC-11w_U&list=PLBcjj47fhbjXhYscBCEBY8-NLhUey4Rsm&index=6


public class QuizContract {//container e.g changing column names

    private QuizContract(){} // constructor to ensure this class is only used as a container

    public static class QuestionsTable implements BaseColumns { //base columns interface for constants, dont need final since already specified in the Quiz Contract class

        //constants that are used in the creation of the quiz database table
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_CHOICE1 = "choice1";
        public static final String COLUMN_CHOICE2 = "choice2";
        public static final String COLUMN_CHOICE3 = "choice3";
        public static final String COLUMN_CORRECT_ANS= "correct_ans";
    }
}
