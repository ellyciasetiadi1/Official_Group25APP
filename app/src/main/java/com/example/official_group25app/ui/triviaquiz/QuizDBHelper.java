package com.example.official_group25app.ui.triviaquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


//This class is utilised in the Data Access Layer, where it interacts with the created database
//youtube reference https://www.youtube.com/watch?v=q0Ev_axWQ_U&list=PLBcjj47fhbjXhYscBCEBY8-NLhUey4Rsm&index=7 used for line 15 to 70
public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RandomTrivia.db"; //name of the database created
    private static final int DATABASE_VERSION = 1; //the first copy of the database
    private SQLiteDatabase db; //reference to the stored database



    //this constructor is needed to fix the error in the class since no default constructor available
    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //this is ONLY called when first accessing the database
        //create initial data passed to reference db overriding SQLLiteOpenHelper whilst adding extra functionality
        this.db = db; //database reference is stored in the db variable
        //using SQL methods to create the database structure
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CHOICE1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CHOICE2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CHOICE3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CORRECT_ANS + " INTEGER" +
                " ) ";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE); //execute SQL LITE Statement on initial creation
        fillQuestionsTable(); //method to add questions
    }

    @Override //If changes need to be made to the database, onCreate is not called, rather version --> 2, and onUpgrade method is called
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME); //when changes are made to the upgrade, table is first dropped and call onCreate again to execute new onCreate method
        onCreate(db); //call the updated onCreate schema

    }

    private void fillQuestionsTable(){ //this adds in the questions to the database
        Question q1 = new Question("What tree gives us prunes?", "Plum", "Banana", "Cherry",1);
        addQuestion(q1); //insert to method and into database
        Question q2 = new Question("What's the groundnut known as?", "Almond", "Peanut", "Walnut",2);
        addQuestion(q2);
        Question q3 = new Question("What's the main ingredient in hash browns?", "Cucumber", "Yams", "Potatoes",3);
        addQuestion(q3);
        Question q4 = new Question("The Buddha hand is a type of what?", "Fruit", "Vegetable", "Spice",1);
        addQuestion(q4);
        Question q5 = new Question("Gumbo originated from?", "Ohio", "Louisiana", "Sydney",2);
        addQuestion(q5);
    }
    //insert created questions and answers in database
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();  //content values class to insert the questions
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion()); //column name to insert value into of the database and the value based on the columns e.g questions and answer options
        cv.put(QuizContract.QuestionsTable.COLUMN_CHOICE1, question.getChoice1());
        cv.put(QuizContract.QuestionsTable.COLUMN_CHOICE2, question.getChoice2());
        cv.put(QuizContract.QuestionsTable.COLUMN_CHOICE3, question.getChoice3());
        cv.put(QuizContract.QuestionsTable.COLUMN_CORRECT_ANS, question.getCorrectans());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv); //insert values in to the database, since reference is stored in db variable

    }

    //questions are in the database, however cant retrieve the data from it yet, need this method //https://www.youtube.com/watch?v=pEDVdSUuWXE&t=488s up to 4.40
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase(); //reference to the database to get the data values
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null); //cursor to query the database

        if(c.moveToFirst()) { //move cursor to first entry in database, if there is entry, query the data
            do{
                Question question = new Question(); //fill question object with the data
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION))); //c is used to get the data out of the database row
                question.setChoice1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CHOICE1)));
                question.setChoice2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CHOICE2)));
                question.setChoice3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CHOICE3)));
                question.setCorrectans(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CORRECT_ANS)));

                //add question object to List <Question> questionList
                questionList.add(question);

            } while (c.moveToNext()); //only moves to next entry

        }

        c.close();
        return questionList;

    }
}
