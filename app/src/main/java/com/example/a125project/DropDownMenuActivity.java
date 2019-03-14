package com.example.a125project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DropDownMenuActivity extends AppCompatActivity {

    Spinner menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //changes questions and answer based on which question users is on
        questionInfo.setQuestionInfo(questionInfo.questionCount);
        menu = findViewById(R.id.spinner1);
        textView = findViewById(R.id.questionText);
        textView.setText(questionInfo.question);

        //determines what string list to display onto drop down menu
        int spinItems = questionInfo.spinnerItemsArrayIndex;
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(DropDownMenuActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(questionInfo.spinnerItems[spinItems]));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(myAdapter);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //since the only two drop down menu we have right now are for height and weight, I stored it in arrays
                //so that we can use it to calculate BMI at the endscreen (ResultActivity)
                questionInfo.spinnerItemsSelection[questionInfo.spinnerItemsArrayIndex] = menu.getSelectedItemPosition();
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


}
