package com.example.a125project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //sets first question information
        questionInfo.setQuestionInfo(questionInfo.questionCount);

        Button startBtn = findViewById(R.id.startButton); // deals with the start button
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

// I used the following links to learn about Android Studio; if you need a better understanding of
// what I did, use the following links:
// https://www.youtube.com/watch?v=fwSJ1OkK304 (deals with radio buttons and radio groups)
// https://www.youtube.com/watch?v=-igAiudpBng (general, slightly outdated)
// https://www.youtube.com/watch?v=dFlPARW5IX8
// https://www.youtube.com/watch?v=6ow3L39Wxmg
