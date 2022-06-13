package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Dynamic Variables for changing content of a view
    TextView countTextView;
    TextView questionTextView;
    RadioButton ans1, ans2, ans3, ans4;
    Button submit, next;

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
        countTextView.setText(R.string.count + totalQuestion);

//        Load questions
        loadNewQuestion();
    }


    /**
     * Loads a new question depending on the value of currentQuestionIndex
     *
     * @param
     */
    void loadNewQuestion() {

        questionTextView.setText(question[currentQuestionIndex]);
        ans1.setText(choices[currentQuestionIndex][0]);
        ans2.setText(choices[currentQuestionIndex][1]);
        ans1.setText(choices[currentQuestionIndex][0]);
    }


    /**
     * Performs an onclick action on the radio buttons and next button
     *
     * @param *view either of the answers or radio button
     */
    public void onRadioButtonClicked(View view) {
       if (ans1.isChecked()) {

       }else if (ans2.isChecked()){

       }else if (ans3.isChecked()) {

       }else if (ans4.isChecked()) {

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