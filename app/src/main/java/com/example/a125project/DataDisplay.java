package com.example.a125project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);

        Button showDataButton = findViewById(R.id.ShowDataButton1);
        showDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream is = getResources().openRawResource(R.raw.fakedata);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                String entireFile = "";
                int lines = 0;
                try {
                    while((line = br.readLine()) != null) { // <--------- place readLine() inside loop
                        lines++;
                        entireFile += (line + "\n"); // <---------- add each line to entireFile
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                TextView outputTextView = findViewById(R.id.data1TextView);
                TextView data1TextView = findViewById(R.id.data2TextView);
                data1TextView.setText(lines + "");
                outputTextView.setText(entireFile); // <------- assign entireFile to TextView
            }
        });
    }
}
