package com.example.a125project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ScaleQuestionActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    RadioButton firstAns;
    RadioButton secondAns;
    RadioButton thirdAns;
    RadioButton fourthAns;
    RadioButton fifthAns;
    RadioButton sixthAns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //changes questions and answer based on which question users is on
        questionInfo.setQuestionInfo(questionInfo.questionCount);
        firstAns = findViewById(R.id.zero);
        secondAns = findViewById(R.id.one);
        thirdAns = findViewById(R.id.two);
        fourthAns = findViewById(R.id.three);
        fifthAns = findViewById(R.id.four);
        sixthAns = findViewById(R.id.five);
        radioGroup = findViewById(R.id.scaleChoices);
        textView = findViewById(R.id.questionText);
        textView.setText(questionInfo.question);
        firstAns.setText(questionInfo.answers[0]);
        secondAns.setText(questionInfo.answers[1]);
        thirdAns.setText(questionInfo.answers[2]);
        fourthAns.setText(questionInfo.answers[3]);
        fifthAns.setText(questionInfo.answers[4]);
        sixthAns.setText(questionInfo.answers[5]);

        //removes the extra options if number of answers are less than 6
        RadioButton[] rbArr = {firstAns, secondAns, thirdAns, fourthAns, fifthAns, sixthAns};
        for(int i = 6; i > questionInfo.numberOfA; i --){
            rbArr[i-1].setVisibility(View.GONE);
        }

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gives score based on what button was pressed
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                questionInfo.answerMap.get("Scale").add(radioId);
                if(radioId == R.id.zero){
                    questionInfo.score += questionInfo.answerValues[0];
                }
                else if(radioId == R.id.one){
                    questionInfo.score += questionInfo.answerValues[1];
                }
                else if(radioId == R.id.two){
                    questionInfo.score += questionInfo.answerValues[2];
                }
                else if(radioId == R.id.three){
                    questionInfo.score += questionInfo.answerValues[3];
                }
                else if(radioId == R.id.four){
                    questionInfo.score += questionInfo.answerValues[4];
                }
                else if(radioId == R.id.five){
                    questionInfo.score += questionInfo.answerValues[5];
                }

                //gets next question
                questionInfo.questionCount++;
                questionInfo.setQuestionInfo(questionInfo.questionCount);

                //intent is determined by what the next question type is, if there is one
                Intent intent;
                if(questionInfo.type == questionInfo.questionType.YESNO){
                    intent = new Intent(getApplicationContext(), YesNoActivity.class);
                }
                else if(questionInfo.type == questionInfo.questionType.SCALE){
                    intent = new Intent(getApplicationContext(), ScaleQuestionActivity.class);
                }
                else if(questionInfo.type == questionInfo.questionType.SPINNER){
                    intent = new Intent(getApplicationContext(), DropDownMenuActivity.class);
                }
                else{
                    intent = new Intent(getApplicationContext(), ResultActivity.class);
                }
                startActivity(intent);
                // code to go to next question and set value or finish survey goes here??
                // use radioButton.getText() to get value of the choice that was selected
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //function to enables next button only after user has selected an answer
    public void clickedButton(View V){
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setEnabled(true);
    }

}
