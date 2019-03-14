package com.example.a125project;

import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

public class questionInfo extends AppCompatActivity {
    //keeps count of what question user is current on
    public static int questionCount = 1;

    //keeps count of user's score
    public static int score = 0;

    //determine questionType so we can decide on which UI templete to use
    public static enum questionType {
        SCALE, YESNO, SPINNER, DONE
    }
    public static questionType type;

    //max # of answer for SCALE type questions
    public static int numberOfA = 6;

    //max # of string arrays that we are going to use for drop down menu
    public static int numberOfSpinnerList = 2;

    //array to store answer options
    public static String[] answers = new String[numberOfA];

    //array to store answer options values for final score calculation
    public static int[] answerValues = new int[numberOfA];

    //current Question's question
    public static String question;

    //stores our drop down menu string list in array
    public static int[] spinnerItems = {R.array.heights, R.array.weights};

    //stores user selection for each drop down menu option
    public static int[] spinnerItemsSelection = new int[numberOfSpinnerList];
    public static int spinnerItemsArrayIndex;

    public static void setQuestionInfo(int questionCount){
        //determines what question user is on and changes the UI accordingly
        switch (questionCount) {
            case 1:
                type = questionType.YESNO;
                question = "Are you a man or a woman?";
                answers[0] = "MALE";
                answers[1] = "FEMALE";
                answerValues[0] = 1;
                answerValues[1] = 0;
                break;
            case 2:
                type= questionType.YESNO;
                question = "Have you ever been diagnosed with gestational diabetes?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 1;
                answerValues[1] = 0;
                break;
            case 3:
                type = questionType.SCALE;
                numberOfA = 4;
                question = "How old are you?";
                answers[0] = "Less than 40 years";
                answers[1] = "40–49 years";
                answers[2] = "50–59 years";
                answers[3] = "60 years or older";
                answerValues[0] = 0;
                answerValues[1] = 1;
                answerValues[2] = 2;
                answerValues[3] = 3;
                break;
            case 4:
                type = questionType.YESNO;
                question = "Do you have a mother, father, sister, or brother with diabetes?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 1;
                answerValues[1] = 0;
                break;
            case 5:
                type = questionType.YESNO;
                question = "Have you ever been diagnosed with high blood pressure?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 1;
                answerValues[1] = 0;
                break;
            case 6:
                type = questionType.YESNO;
                question = "Are you physically active?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 0;
                answerValues[1] = 1;
                break;
            case 7:
                type = questionType.SPINNER;
                question = "How tall are you?";
                spinnerItemsArrayIndex = 0;
                break;
            case 8:
                type = questionType.SPINNER;
                question = "Please select your weight.";
                spinnerItemsArrayIndex = 1;
                break;
            case 9:
                type = questionType.SCALE;
                question = "What race or ethnicity best describes you?";
                numberOfA = 6;
                answers[0] = "African Americans";
                answers[1] = "Hispanic/Latino Americans";
                answers[2] = "American Indians";
                answers[3] = "Asian Americans";
                answers[4] = "Pacific Islanders";
                answers[5] = "Others";
                answerValues[0] = 1;
                answerValues[1] = 1;
                answerValues[2] = 1;
                answerValues[3] = 1;
                answerValues[4] = 1;
                answerValues[5] = 0;
                break;
            default:
                type = questionType.DONE;
                break;
        }
    }
}
