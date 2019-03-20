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

public class YesNoActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    RadioButton firstAns;
    RadioButton secondAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_no);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //changes questions and answer based on which question users is on
        questionInfo.setQuestionInfo(questionInfo.questionCount);
        firstAns = findViewById(R.id.first);
        secondAns = findViewById(R.id.second);
        radioGroup = findViewById(R.id.yesNoChoices);
        textView = findViewById(R.id.questionText);
        textView.setText(questionInfo.question);
        firstAns.setText(questionInfo.answers[0]);
        secondAns.setText(questionInfo.answers[1]);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gives score based on what button was pressed
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                questionInfo.answerMap.get("YN").add(radioId);
                if(radioId == R.id.first){
                    questionInfo.score += questionInfo.answerValues[0];
                    //special if-statement only for question 1
                    //There is an extra question only if user is female, this if-statement will skip that question if user is male
                    if(questionInfo.questionCount == 1){
                        questionInfo.questionCount++;
                    }
                }
                else if(radioId == R.id.second){
                    questionInfo.score += questionInfo.answerValues[1];
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

    public void clickedButton(View V){
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setEnabled(true);
    }


}
