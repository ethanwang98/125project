package com.example.a125project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //calculate pseudo BMI, rough estimate of BMI
        if((questionInfo.spinnerItemsSelection[0] <= 1 && questionInfo.spinnerItemsSelection[1] >= 0) ||
                (questionInfo.spinnerItemsSelection[0] <= 7 && questionInfo.spinnerItemsSelection[1] >= 2) ||
                (questionInfo.spinnerItemsSelection[1] >= 3)){
            questionInfo.score++;
        }

        //score
        textView = findViewById(R.id.scoreText);
        String result = questionInfo.score + " / 10";
        textView.setText(result);

        //score evaluation result
        textView = findViewById(R.id.resultStatement);
        if(questionInfo.score >= 5){
            textView.setText("HIGH RISK OF DIABETES");
        }
        else{
            textView.setText("LOW RISK OF DIABETES");
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //reset questionCount and score
        questionInfo.questionCount = 1;
        questionInfo.score = 0;

        Button returnBtn = (Button) findViewById(R.id.returnToTitle);
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
