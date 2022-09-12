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
    CheckBox checkBoxOption1, checkBoxOption2, checkBoxOption3, checkBoxOption4;

    int score = 0;
    int totalQuestion = question.length;
    int currentQuestionIndex = 0;
    String currentAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Get views by their Ids
        countTextView = findViewById(R.id.number_of_question_text_view);
        questionTextView = findViewById(R.id.question_text_view);
        answerA = findViewById(R.id.option_a_text_view);
        answerB = findViewById(R.id.option_b_text_view);
        answerC = findViewById(R.id.option_c_text_view);
        answerD = findViewById(R.id.option_d_text_view);
        nextButton = findViewById(R.id.next_button_text_view);
        scrollView = findViewById(R.id.main);
        allAnswers = findViewById(R.id.radio_group_text_view);
        checkBoxLayout = findViewById(R.id.checkbox_wrapper);
        checkBoxOption1 = findViewById(R.id.checkbox1_text_view);
        checkBoxOption2 = findViewById(R.id.checkbox2_text_view);
        checkBoxOption3 = findViewById(R.id.checkbox3_text_view);
        checkBoxOption4 = findViewById(R.id.checkbox4_text_view);
        inputText = findViewById(R.id.edit_text_view);
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
        checkBoxOption1.setChecked(false);
        checkBoxOption2.setChecked(false);
        checkBoxOption3.setChecked(false);
        checkBoxOption4.setChecked(false);
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
            if (checkBoxOption1.isChecked() == true && checkBoxOption2.isChecked() == true && checkBoxOption3.isChecked() == false && checkBoxOption4.isChecked() == false) {
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