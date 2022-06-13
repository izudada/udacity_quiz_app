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
    RadioButton ans1, ans2, ans3, ans4, ans5;
    Button submit, next;

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
    }

    public void onRadioButtonClicked(View view) {
       if (ans1.isChecked()) {

       }else if (ans2.isChecked()){

       }else if (ans3.isChecked()) {

       }else if (ans4.isChecked()) {

       }
    }


    public static String question [] = {
        "How many computer languages are in use?",
        "Who founded Apple Computer?",
        "What does the Internet prefix WWW stand for?",
        "A network designed to allow communication within an organization is called:",
        "Which of these is not an early computer?"
    };

    public static String choices [][] = {
            {"4312", "2000", "4000", "3200"},
            {"Bill Gates", "Stephen Fry", "Steve Jobs", "Stephen Hawking"},
            {"World Wide Web", "Western Washington World", "Worldwide Weather", "Wide Width Wickets"},
            {"the Internet", "the World Wide Web", "Yahoo", "an intranet"},
            {"NASA", "SAGE", "UNIVAC", "ENIAC"}
    };

    public static String correctAnswers [] = {
        "2000",
        "Steve Jobs",
        "World Wide Web",
        "an intranet",
        "NASA"
    };
}