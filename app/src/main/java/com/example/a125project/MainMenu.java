package com.example.a125project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // for now they go to the same scene
        Button see_data_but_txt = findViewById(R.id.DataBtnText);
        see_data_but_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent is determined by what the next question type is, if there is one
                Intent intent;
                if (questionInfo.type == questionInfo.questionType.YESNO) {
                    intent = new Intent(getApplicationContext(), YesNoActivity.class);
                } else if (questionInfo.type == questionInfo.questionType.SCALE) {
                    intent = new Intent(getApplicationContext(), ScaleQuestionActivity.class);
                } else if (questionInfo.type == questionInfo.questionType.SPINNER) {
                    intent = new Intent(getApplicationContext(), DropDownMenuActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), ResultActivity.class);
                }
                startActivity(intent);
            }
        });
        Button answer_question_btn_txt = findViewById(R.id.QuestionaireBtnText);
        answer_question_btn_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent is determined by what the next question type is, if there is one
                Intent intent;
                if (questionInfo.type == questionInfo.questionType.YESNO) {
                    intent = new Intent(getApplicationContext(), YesNoActivity.class);
                } else if (questionInfo.type == questionInfo.questionType.SCALE) {
                    intent = new Intent(getApplicationContext(), ScaleQuestionActivity.class);
                } else if (questionInfo.type == questionInfo.questionType.SPINNER) {
                    intent = new Intent(getApplicationContext(), DropDownMenuActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), ResultActivity.class);
                }
                startActivity(intent);
            }
        });


    }
}
