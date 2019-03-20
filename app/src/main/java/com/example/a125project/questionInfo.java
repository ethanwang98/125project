package com.example.a125project;

import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class questionInfo extends AppCompatActivity {
    //keeps count of what question user is current on
    public static int questionCount = 1;

    //keeps count of user's score
    public static float score = 0;

    //determine questionType so we can decide on which UI templete to use
    public static enum questionType {
        SCALE, YESNO, SPINNER, DONE
    }
    public static questionType type;

    //max # of answer for SCALE type questions
    public static int numberOfA = 6;

    //max # of string arrays that we are going to use for drop down menu
    public static int numberOfSpinnerList = 3;

    //array to store answer options
    public static String[] answers = new String[numberOfA];

    //array to store answer options values for final score calculation
    public static float[] answerValues = new float[numberOfA];

    //records and saves all answers along with the type of question
    public static defaultdict<String, ArrayList<Integer>> answerMap = new defaultdict<String, ArrayList<Integer>>(ArrayList.class);

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
                type = questionType.SCALE;
                numberOfA = 4;
                question = "How old are you?";
                answers[0] = "4-14 years old";
                answers[1] = "15-26 years old";
                answers[2] = "26-44 years old";
                answers[3] = "45+ years old";
                answerValues[0] = 3;
                answerValues[1] = 2;
                answerValues[2] = 1;
                answerValues[3] = 5;
                break;
            case 2:
                type = questionType.YESNO;
                question = "If you have a parent or sibling with diabetes, does he/she have type 1 diabetes?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 1;
                answerValues[1] = 0;
                break;
            case 3:
                type = questionType.YESNO;
                question = "If you have a parent or sibling with diabetes, does he/she have type 2 diabetes?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = (float)0.5;
                answerValues[1] = 0;
                break;
            case 4:
                type = questionType.SCALE;
                question = "You often feel depressed or experience fatigue throughout the day";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 5:
                type = questionType.SCALE;
                question = "You feel like you get hungry/thirsty often";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.2;
                answerValues[1] = (float)0.9;
                answerValues[2] = (float)0.6;
                answerValues[3] = (float)0.3;
                answerValues[4] = 0;
                break;
            case 6:
                type = questionType.SCALE;
                question = "You tend to lose weight without any apparent reason";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.2;
                answerValues[1] = (float)0.9;
                answerValues[2] = (float)0.6;
                answerValues[3] = (float)0.3;
                answerValues[4] = 0;
                break;
            case 7:
                type = questionType.SCALE;
                question = "You experience trouble breathing";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.6;
                answerValues[1] = (float)1.2;
                answerValues[2] = (float)0.8;
                answerValues[3] = (float)0.4;
                answerValues[4] = 0;
                break;
            case 8:
                type = questionType.SCALE;
                question = "You experience episodes of nausea and vomiting";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.6;
                answerValues[1] = (float)1.2;
                answerValues[2] = (float)0.8;
                answerValues[3] = (float)0.4;
                answerValues[4] = 0;
                break;
            case 9:
                type = questionType.SCALE;
                question = "You experience blurry vision";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)0.8;
                answerValues[1] = (float)0.6;
                answerValues[2] = (float)0.4;
                answerValues[3] = (float)0.2;
                answerValues[4] = 0;
                break;
            case 10:
                type = questionType.SCALE;
                question = "You experience dry or flushed skin";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.6;
                answerValues[1] = (float)1.2;
                answerValues[2] = (float)0.8;
                answerValues[3] = (float)0.4;
                answerValues[4] = 0;
                break;
            case 11:
                type = questionType.SCALE;
                question = "You have trouble paying attention or sometimes feel confused";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 12:
                type = questionType.SCALE;
                question = "Your breath smells fruity";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)2.4;
                answerValues[1] = (float)1.8;
                answerValues[2] = (float)1.2;
                answerValues[3] = (float)0.6;
                answerValues[4] = 0;
                break;
            case 13:
                type = questionType.SCALE;
                question = "You experience stomach pain for no apparent reason";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 14:
                type = questionType.SCALE;
                question = "You feel the need to urinate often";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 15:
                type = questionType.SCALE;
                question = "You tend to get irritated or experience mood swings";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.2;
                answerValues[1] = (float)0.9;
                answerValues[2] = (float)0.6;
                answerValues[3] = (float)0.3;
                answerValues[4] = 0;
                break;
            case 16:
                type = questionType.SCALE;
                question = "Your mouth often feels dry";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.2;
                answerValues[1] = (float)0.9;
                answerValues[2] = (float)0.6;
                answerValues[3] = (float)0.3;
                answerValues[4] = 0;
                break;
            case 17:
                type = questionType.SCALE;
                question = "You are not physically active";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 18:
                type = questionType.SCALE;
                question = "You sweat while not physically active";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)0.8;
                answerValues[1] = (float)0.6;
                answerValues[2] = (float)0.4;
                answerValues[3] = (float)0.2;
                answerValues[4] = 0;
                break;
            case 19:
                type = questionType.SCALE;
                question = "Your diet includes a lot of high cholesterol and/or foods high in sugar levels";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 20:
                type = questionType.SCALE;
                question = "You experience numbness or tingling in the feet or hands";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 21:
                type = questionType.SCALE;
                question = "You have low levels of HDL(good cholesterol)";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = 2;
                answerValues[1] = (float)1.5;
                answerValues[2] = 1;
                answerValues[3] = (float)0.5;
                answerValues[4] = 0;
                break;
            case 22:
                type = questionType.SCALE;
                question = "You notice patches of dark, velvety skin around neck or armpits";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)2.8;
                answerValues[1] = (float)2.1;
                answerValues[2] = (float)1.4;
                answerValues[3] = (float)0.7;
                answerValues[4] = 0;
                break;
            case 23:
                type = questionType.SCALE;
                question = "Your cuts/sores take long to recover";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.2;
                answerValues[1] = (float)0.9;
                answerValues[2] = (float)0.6;
                answerValues[3] = (float)0.3;
                answerValues[4] = 0;
                break;
            case 24:
                type = questionType.SCALE;
                question = "You experience headaches for no apparent reason";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)1.6;
                answerValues[1] = (float)1.2;
                answerValues[2] = (float)0.8;
                answerValues[3] = (float)0.4;
                answerValues[4] = 0;
                break;
            case 25:
                type = questionType.SCALE;
                question = "You get frequent infections";
                numberOfA = 5;
                answers[0] = "Strongly Agree";
                answers[1] = "Agree";
                answers[2] = "Neutral";
                answers[3] = "Disagree";
                answers[4] = "Strongly Disagree";
                answerValues[0] = (float)0.8;
                answerValues[1] = (float)0.6;
                answerValues[2] = (float)0.4;
                answerValues[3] = (float)0.2;
                answerValues[4] = 0;
                break;
            case 26:
                type = questionType.SCALE;
                question = "What is your BMI?";
                numberOfA = 4;
                answers[0] = "Below 19";
                answers[1] = "19-24";
                answers[2] = "26-30";
                answers[3] = "30+";
                answerValues[0] = 0;
                answerValues[1] = 0;
                answerValues[2] = (float)1.5;
                answerValues[3] = 3;
                break;
            case 27:
                type = questionType.SCALE;
                question = "What best describes your ethnicity?";
                numberOfA = 6;
                answers[0] = "Asian American";
                answers[1] = "African American";
                answers[2] = "American Indian";
                answers[3] = "Pacific Islander";
                answers[4] = "Latino";
                answers[5] = "Other";
                answerValues[0] = 1;
                answerValues[1] = 1;
                answerValues[2] = 1;
                answerValues[3] = 1;
                answerValues[4] = 1;
                answerValues[5] = 0;
                break;
            case 28:
                type = questionType.YESNO;
                question = "Do you have a history of heart disease/stroke?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 2;
                answerValues[1] = 0;
                break;
            case 29:
                type = questionType.YESNO;
                question = "Did you have a low birthweight? (less than 5 lbs)";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 1;
                answerValues[1] = 0;
                break;
            case 30:
                type = questionType.YESNO;
                question = "Is your blood pressure higher than 140/90?";
                answers[0] = "Yes";
                answers[1] = "No";
                answerValues[0] = 3;
                answerValues[1] = 0;
                break;
            default:
                type = questionType.DONE;
                break;
        }
    }
}