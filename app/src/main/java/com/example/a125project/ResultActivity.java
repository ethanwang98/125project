package com.example.a125project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ListView;

import org.w3c.dom.Text;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        defaultdict<String, ArrayList<Integer>> answers = questionInfo.answerMap;
        int count = 0;
        boolean young_age = false;
        boolean old_age = false;
        for (int answer : answers.get("Scale")){
            if (answer < 2){
                count += 1;
            }
        }
        if (answers.get("Scale").get(0) < 2){
            young_age = true;
        }
        else if (answers.get("Scale").get(0) == 3){
            old_age = true;
        }
        if (count >= 2 && young_age == true)
            questionInfo.score += 10;
        else if (count >= 2 && old_age == true){
            count = 0;
            if (answers.get("YN").get(2) == 0)
                count += 1;
            if (answers.get("SCALE").get(2) < 2)
                count += 1;
            if (answers.get("SCALE").get(15) < 2)
                count += 1;
            if (answers.get("SCALE").get(19) < 2)
                count += 1;
            if (answers.get("SCALE").get(20) < 2)
                count += 1;
            if (answers.get("SCALE").get(25) < 5)
                count += 1;
            if (answers.get("YN").get(3) == 0)
                count += 1;
            if (answers.get("YN").get(5) == 0)
                count += 1;
            if (count >= 2)
                questionInfo.score += 10;
        }


        //score
        textView = findViewById(R.id.scoreText);
        String result = Float.toString(questionInfo.score);
        textView.setText(result);

        //score evaluation result
        textView = findViewById(R.id.resultStatement);
        if(questionInfo.score >= 30){
            textView.setText("HIGH RISK OF DIABETES");
        }
        else if (questionInfo.score >= 15 && questionInfo.score < 30){
            textView.setText("MODERATE RISK OF DIABETES");
        }
        else{
            textView.setText("LOW RISK OF DIABETES");
        }

        String[] genGuide = getResources().getStringArray(R.array.generalGuidance);
        StringBuilder builder = new StringBuilder();
        for (String s: genGuide) {
            builder.append(s);
            builder.append("\n\n");
        }
        textView = findViewById(R.id.generalAdviceText);
        textView.setText(builder.toString());


//        listView = findViewById(R.id.generalAdviceText);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ResultActivity.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.generalGuidance));
//
//        listView.setAdapter(adapter);

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
