package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Dynamic Variables for changing content of a view
    TextView countTextView;
    TextView questionTextView;
    RadioButton ans1, ans2, ans3, ans4;
    Button next;
    ScrollView main;
    RadioGroup allAnswers;
    EditText input;
    LinearLayout checkBoxLayout;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

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
        main = findViewById(R.id.main);
        allAnswers = findViewById(R.id.radio_group);
        checkBoxLayout = findViewById(R.id.checkboxes);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        input = findViewById(R.id.input);
        input.setVisibility(View.INVISIBLE);
        checkBoxLayout.setVisibility(View.INVISIBLE);
//        Get the total number of questions and set text
        countTextView.setText("Total umber of question " + totalQuestion);
//        Load questions
        loadNewQuestion();
    }

    /**
     * Loads a new question and answers depending on the value of currentQuestionIndex
     *
     */
    void loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            endQuiz();
            return;
        }
        if (currentQuestionIndex == 3) {
            allAnswers.setVisibility(View.GONE);
            input.setVisibility(View.INVISIBLE);
            checkBoxLayout.setVisibility(View.VISIBLE);
        }else if (currentQuestionIndex == 4) {
//            Hide radio buttons to insert edit text
            checkBoxLayout.setVisibility(View.INVISIBLE);
            allAnswers.setVisibility(View.GONE);
            input.setVisibility(View.VISIBLE);
        }
        questionTextView.setText(question[currentQuestionIndex]);
        ans1.setText(choices[currentQuestionIndex][0]);
        ans2.setText(choices[currentQuestionIndex][1]);
        ans3.setText(choices[currentQuestionIndex][2]);
        ans4.setText(choices[currentQuestionIndex][3]);
    }

    /**
     * Marks the end of a quiz
     *
     */
    void endQuiz() {
        String endearment;
        if (score > totalQuestion * 0.50) {
            endearment = "Well done ";
        } else {
            endearment = "Try again ";
        }
        Toast.makeText(this, endearment + " You scored " + score + " out of " + totalQuestion, Toast.LENGTH_LONG).show();
        restartQuiz();
    }

    /**
     * Performs a quiz restart action
     *
     */
    void restartQuiz () {
        allAnswers.setVisibility(View.VISIBLE);
        input.getText().clear();
        input.setVisibility(View.INVISIBLE);
        checkBoxLayout.setVisibility(View.INVISIBLE);
        score = 0;
        currentQuestionIndex = 0;
        next.setText(R.string.next);
        loadNewQuestion();
    }

    /**
     * Performs an onclick action on the radio buttons
     *
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
     */
    public void onNextButtonClicked(View view) {
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

        if (currentQuestionIndex == 3) {
            if (checkBox1.isChecked() == true && checkBox1.isChecked() == true && checkBox3.isChecked() == false && checkBox4.isChecked() == false) {
                score++ ;
            }
        }
        if (currentQuestionIndex == 4) {
            currentAnswer = input.getText().toString();
        }

        if (currentAnswer.equals(correctAnswers[currentQuestionIndex])) {
            score++ ;
        }
//            Action if the next button is clicked
        currentQuestionIndex++ ;
        loadNewQuestion();

    }

    /**
     * Creates an array/list of questions
     *
     */
    public static String question [] = {
        "How many computer languages are in use?",
        "What does the Internet prefix WWW stand for?",
        "A network designed to allow communication within an organization is called:",
        "Which of these is not a programming language?",
        "Who founded Apple Computer?"
    };

    /**
     * A 2 dimensional array/list of answers to the above questions
     *
     */
    public static String choices [][] = {
            {"4312", "2000", "4000", "3200"},
            {"World Wide Web", "Western Washington World", "Worldwide Weather", "Wide Width Wickets"},
            {"the Internet", "the World Wide Web", "Yahoo", "an intranet"},
            {"Python", "Java", "UNIVAC", "ENIAC"},
            {"Bill Gates", "Stephen Fry", "Steve Jobs", "Stephen Hawking"}
    };

    /**
     * An array/list of correct answers
     *
     */
    public static String correctAnswers [] = {
        "2000",
        "World Wide Web",
        "an intranet",
        "NASA",
        "Steve Jobs"
    };
}