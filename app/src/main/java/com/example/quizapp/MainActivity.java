package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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