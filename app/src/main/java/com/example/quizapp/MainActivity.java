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
    RadioButton answerA, answerB, answerC, answerD;
    Button nextButton;
    ScrollView scrollView;
    RadioGroup allAnswers;
    EditText inputText;
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
        answerA = findViewById(R.id.answer1);
        answerB = findViewById(R.id.answer2);
        answerC = findViewById(R.id.answer3);
        answerD = findViewById(R.id.answer4);
        nextButton = findViewById(R.id.next);
        scrollView = findViewById(R.id.main);
        allAnswers = findViewById(R.id.radio_group);
        checkBoxLayout = findViewById(R.id.checkboxes);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        checkBox4 = findViewById(R.id.checkbox4);
        inputText = findViewById(R.id.input);
        inputText.setVisibility(View.INVISIBLE);
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
            inputText.setVisibility(View.INVISIBLE);
            checkBoxLayout.setVisibility(View.VISIBLE);
        }else if (currentQuestionIndex == 4) {
//            Hide radio buttons to insert edit text
            checkBoxLayout.setVisibility(View.INVISIBLE);
            allAnswers.setVisibility(View.GONE);
            inputText.setVisibility(View.VISIBLE);
        }
        questionTextView.setText(question[currentQuestionIndex]);
        answerA.setText(choices[currentQuestionIndex][0]);
        answerB.setText(choices[currentQuestionIndex][1]);
        answerC.setText(choices[currentQuestionIndex][2]);
        answerD.setText(choices[currentQuestionIndex][3]);
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
        inputText.getText().clear();
        inputText.setVisibility(View.INVISIBLE);
        checkBoxLayout.setVisibility(View.INVISIBLE);
        score = 0;
        currentQuestionIndex = 0;
        nextButton.setText(R.string.next);
        loadNewQuestion();
    }

    /**
     * Performs an onclick action on the radio buttons
     *
     */
    public void onRadioButtonClicked(View view) {
//        Reset the color of each radio button when option selected changes
        answerA.setTextColor(Color.WHITE);
        answerB.setTextColor(Color.WHITE);
        answerC.setTextColor(Color.WHITE);
        answerD.setTextColor(Color.WHITE);
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
            nextButton.setText(R.string.submit);
        }
        answerA.setTextColor(Color.WHITE);
        answerA.setChecked(false);
        answerB.setTextColor(Color.WHITE);
        answerB.setChecked(false);
        answerC.setTextColor(Color.WHITE);
        answerC.setChecked(false);
        answerD.setTextColor(Color.WHITE);
        answerD.setChecked(false);

        if (currentQuestionIndex == 3) {
            if (checkBox1.isChecked() == true && checkBox1.isChecked() == true && checkBox3.isChecked() == false && checkBox4.isChecked() == false) {
                score++ ;
            }
        }
        if (currentQuestionIndex == 4) {
            currentAnswer = inputText.getText().toString();
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
//        The below empty string is a feature and not a bug, Please
        "",
        "Steve Jobs"
    };
}