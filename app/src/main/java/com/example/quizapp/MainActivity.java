package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Dynamic Variables for changing content of a view
    TextView countTextView;
    TextView questionTextView;
    RadioButton ans1, ans2, ans3, ans4;
    Button next;

    int score = 0;
    int totalQuestion = question.length;
    int currentQuestionIndex = 0;
    String currentAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Get views by their Ids
        countTextView = findViewById(R.id.count);
        questionTextView = findViewById(R.id.question);
        ans1 = findViewById(R.id.answer1);
        ans2 = findViewById(R.id.answer2);
        ans3 = findViewById(R.id.answer3);
        ans4 = findViewById(R.id.answer4);
        next = findViewById(R.id.next);

//        Get the total number of questions and set text
        countTextView.setText("Total Number Of Question: " + totalQuestion);

//        Load questions
        loadNewQuestion();
    }


    /**
     * Loads a new question and answers depending on the value of currentQuestionIndex
     *
     * @param
     */
    void loadNewQuestion() {

        questionTextView.setText(question[currentQuestionIndex]);
        ans1.setText(choices[currentQuestionIndex][0]);
        ans2.setText(choices[currentQuestionIndex][1]);
        ans3.setText(choices[currentQuestionIndex][2]);
        ans4.setText(choices[currentQuestionIndex][3]);
    }


    /**
     * Performs an onclick action on the radio buttons
     *
     * @param *view either of the answers or radio button
     */
    public void onRadioButtonClicked(View view) {

//        Reset the color of each radio button when option selected changes
        ans1.setTextColor(Color.WHITE);
        ans2.setTextColor(Color.WHITE);
        ans3.setTextColor(Color.WHITE);
        ans4.setTextColor(Color.WHITE);

        // Is the button now checked?
        RadioButton checked = (RadioButton) view;

//            Action when a radio button is clicked
        currentAnswer = checked.getText().toString();
        checked.setTextColor(Color.YELLOW);

    }


    /**
     * Performs an onclick action on the next button
     *
     * @param *view either of the answers or radio button
     */
    public void onNextButtonClicked(View view) {
        Log.v("Main Activity", ""+currentQuestionIndex +" " + totalQuestion );
        if (currentQuestionIndex == 3) {
            next.setText(R.string.submit);
        }

        ans1.setTextColor(Color.WHITE);
        ans1.setChecked(false);
        ans2.setTextColor(Color.WHITE);
        ans2.setChecked(false);
        ans3.setTextColor(Color.WHITE);
        ans3.setChecked(false);
        ans4.setTextColor(Color.WHITE);
        ans4.setChecked(false);

//            Action if the next button is clicked
        currentQuestionIndex++ ;
        loadNewQuestion();

        if (currentAnswer.equals(correctAnswers[currentQuestionIndex])) {
            score++ ;
        }

    }


    /**
     * Creates an array/list of questions
     *
     * @param
     */
    public static String question [] = {
        "How many computer languages are in use?",
        "Who founded Apple Computer?",
        "What does the Internet prefix WWW stand for?",
        "A network designed to allow communication within an organization is called:",
        "Which of these is not an early computer?"
    };


    /**
     * A 2 dimensional array/list of answers to the above questions
     *
     * @param
     */
    public static String choices [][] = {
            {"4312", "2000", "4000", "3200"},
            {"Bill Gates", "Stephen Fry", "Steve Jobs", "Stephen Hawking"},
            {"World Wide Web", "Western Washington World", "Worldwide Weather", "Wide Width Wickets"},
            {"the Internet", "the World Wide Web", "Yahoo", "an intranet"},
            {"NASA", "SAGE", "UNIVAC", "ENIAC"}
    };


    /**
     * An array/list of correct answers
     *
     * @param
     */
    public static String correctAnswers [] = {
        "2000",
        "Steve Jobs",
        "World Wide Web",
        "an intranet",
        "NASA"
    };
}