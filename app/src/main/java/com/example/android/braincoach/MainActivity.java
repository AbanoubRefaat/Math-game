package com.example.android.braincoach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.GridLayout;
import android.widget.Toast;

import java.io.IOException;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView    score,
                        timer,
                        equation;

    private ConstraintLayout constraint;
    private GridLayout gridLayout;
    private LinearLayout linear;
    public Button goButton ,goThirty, exitBt, answer_1, answer_2, answer_3, answer_4;
   private final String good = "Good Job , your answer is correct";
   private final String bad = "Its wrong , try again";
    private int scoreNumber = 0;
    private int  timeCounter = 30;
    private int equationNum = 0;

    private EditText editText;
    private boolean customeTimer  = false;
    private boolean isStarted = false;

    CountDownTimer count;

    int result,assignment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        goButton = (Button) findViewById(R.id.newGame);
        goThirty = (Button)findViewById(R.id.start);
        exitBt = (Button) findViewById(R.id.exit);

        editText = (EditText)findViewById(R.id.editTimer) ;

        score = (TextView) findViewById(R.id.score);
        timer = (TextView) findViewById(R.id.timer_text);
        equation = (TextView) findViewById(R.id.equation);

        answer_1 = (Button) findViewById(R.id.answer_1);
        answer_2 = (Button) findViewById(R.id.answer_2);
        answer_3 = (Button) findViewById(R.id.answer_3);
        answer_4 = (Button) findViewById(R.id.answer_4);

        answer_1.setClickable(false);
        answer_2.setClickable(false);
        answer_3.setClickable(false);
        answer_4.setClickable(false);




        constraint = (ConstraintLayout)findViewById(R.id.main_layout);
        gridLayout = (GridLayout) findViewById(R.id.grid_layout);
        linear = (LinearLayout)findViewById(R.id.Linear);

        gridLayout.setVisibility(View.INVISIBLE);
        linear.setVisibility(View.INVISIBLE);


        answer_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (v.isClickable()){
                   if (assignment == 0){
                       Toast.makeText(getApplicationContext(),good,Toast.LENGTH_SHORT).show();
                       generatingEquation();
                       correctRand();
                       fakeAnswers(assignment);
                       scoreNumber++;
                       score.setText(String.valueOf(scoreNumber+"/"+equationNum));

                   }else {
                       Toast.makeText(getApplicationContext(),bad,Toast.LENGTH_SHORT).show();
                       generatingEquation();
                       correctRand();
                       fakeAnswers(assignment);
                   }
               }

            }
        });

        answer_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.isClickable()){
                    if (assignment == 1){
                        Toast.makeText(getApplicationContext(),good,Toast.LENGTH_SHORT).show();
                        generatingEquation();
                        correctRand();
                        fakeAnswers(assignment);
                        scoreNumber++;
                        score.setText(String.valueOf(scoreNumber+"/"+equationNum));


                    }else {
                        Toast.makeText(getApplicationContext(),bad,Toast.LENGTH_SHORT).show();
                        generatingEquation();
                        correctRand();
                        fakeAnswers(assignment);
                    }
                }

            }
        });

        answer_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.isClickable()){
                    if (assignment == 2){
                        Toast.makeText(getApplicationContext(),good,Toast.LENGTH_SHORT).show();
                        generatingEquation();
                        correctRand();
                        fakeAnswers(assignment);
                        scoreNumber++;
                        score.setText(String.valueOf(scoreNumber+"/"+equationNum));

                    }else {
                        Toast.makeText(getApplicationContext(),bad,Toast.LENGTH_SHORT).show();
                        generatingEquation();
                        correctRand();
                        fakeAnswers(assignment);
                    }
                }

            }
        });

        answer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.isClickable()){
                    if (assignment == 3){
                        Toast.makeText(getApplicationContext(),good,Toast.LENGTH_SHORT).show();
                        generatingEquation();
                        correctRand();
                        fakeAnswers(assignment);
                        scoreNumber++;
                        score.setText(String.valueOf(scoreNumber+"/"+equationNum));

                    }else {
                        Toast.makeText(getApplicationContext(),bad,Toast.LENGTH_SHORT).show();
                        generatingEquation();
                        correctRand();
                        fakeAnswers(assignment);
                    }
                }

            }
        });


        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setVisibility(View.INVISIBLE);
                goThirty.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);


                if (editText.getText().toString().isEmpty()){

                    equation.setGravity(Gravity.CENTER_HORIZONTAL);
                    linear.setVisibility(View.VISIBLE);
                    score.setLayoutParams(new LinearLayout.LayoutParams(0,0,0f));
                    timer.setLayoutParams(new LinearLayout.LayoutParams(0,0,0f));
                    String s = getString(R.string.empty_et);
                    equation.setVisibility(View.VISIBLE);
                    equation.setTextColor(getResources().getColor(R.color.empty_in));
                    equation.setText(s);

                    v.setVisibility(View.VISIBLE);
                    editText.setVisibility(View.VISIBLE);
                    goThirty.setVisibility(View.VISIBLE);

                    answer_1.setClickable(false);
                    answer_2.setClickable(false);
                    answer_3.setClickable(false);
                    answer_4.setClickable(false);



                }else {
                    score.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,2f));
                    timer.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,2f));
                    equation.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,4f));

                    equation.setTextColor(getResources().getColor(R.color.equation_tColor));

                    goThirty.setVisibility(View.INVISIBLE);

                    timer.setVisibility(View.VISIBLE);
                    score.setVisibility(View.VISIBLE);
                    ;

                    LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT

                            );


                    equation.setLayoutParams(p);
                    equation.setGravity(Gravity.CENTER_HORIZONTAL);
                    String editTextTimer = editText.getText().toString();
                    Long mSeconds = Long.valueOf(editTextTimer);
                    mSeconds = mSeconds *1000;

                    Log.v("EditTextTimer","M.S = "+mSeconds);
//                    equation.setText(equationNum);
                    startingTimer(mSeconds);
                    start();
                    isStarted = true;
                    if (isStarted) {
                        linear.setVisibility(View.VISIBLE);

                        score.setGravity(Gravity.CENTER_HORIZONTAL);
                        timer.setGravity(Gravity.CENTER_HORIZONTAL);
                        gridLayout.setVisibility(View.VISIBLE);
                        answer_1.setClickable(true);
                        answer_2.setClickable(true);
                        answer_3.setClickable(true);
                        answer_4.setClickable(true);
                    }
                }



            }
        });





        goThirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setVisibility(View.INVISIBLE);
                goButton.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);

               isStarted = true;
               if (isStarted){
                   score.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,3f));
                   equation.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,4f));
                   timer.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,2f));

                   linear.setVisibility(View.VISIBLE);
                   gridLayout.setVisibility(View.VISIBLE);
                   start();
                   startingTimer(30000);
                   answer_1.setClickable(true);
                   answer_2.setClickable(true);
                   answer_3.setClickable(true);
                   answer_4.setClickable(true);

               }
            }
        });




    }

    public void start() {

        generatingEquation();

        goButton.setVisibility(View.INVISIBLE);

            correctRand();
            fakeAnswers(assignment);



    }
    public void exit(View view) {

        this.finish();
    }

    public void generatingEquation() {

        equationNum++;
        score.setText(String.valueOf(scoreNumber+"/"+equationNum));
        Random random = new Random();

        int x = random.nextInt(100);
        int y = random.nextInt(100);
        String randEquation = Integer.toString(x) + " + " + Integer.toString(y);
        equation.setText(randEquation);
        result = x + y;


    }

    public void correctRand () {
        Random rand4 = new Random();
        int fourth = rand4.nextInt(4);

        if (fourth != -1) {

            String res = String.valueOf(result);

            switch (fourth) {
                case 0:
                    answer_1.setText(res);
                    answer_1.setTextSize(40);
                    assignment = 0;
                    break;
                case 1:
                    answer_2.setText(res);
                    answer_2.setTextSize(40);
                    assignment = 1;

                    break;
                case 2:
                    answer_3.setText(res);
                    answer_3.setTextSize(40);
                    assignment = 2;

                    break;
                case 3:
                    answer_4.setText(res);
                    answer_4.setTextSize(40);
                    assignment = 3;

                    break;
            }

        } else {
            Log.v("Fourth", "is = " + fourth);
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();

        }
    }

    public void fakeAnswers(int ass){
        ass = assignment;

        Random random1 = new Random();
        int rand1 = random1.nextInt(150);
        if (rand1 == result){
             rand1 = random1.nextInt(150);
             Log.v("Random","Random was repeated");

        }

        Random random2 = new Random();
        int rand2 = random2.nextInt(150);
        if (rand2 == result){
            rand2 = random1.nextInt(150);
            Log.v("Random","Random was repeated");

        }

        Random random3 = new Random();
        int rand3 = random3.nextInt(150);
        if (rand3 == result){
            rand3 = random1.nextInt(150);
            Log.v("Random","Random was repeated");


        }


        switch (ass){


            case 0:
                Log.v("Assignment","0");
                answer_2.setText(String.valueOf(rand1));
                answer_2.setTextSize(40);
                answer_3.setText(String.valueOf(rand2));
                answer_3.setTextSize(40);
                answer_4.setText(String.valueOf(rand3));
                answer_4.setTextSize(40);


                break;
            case 1:
                Log.v("Assignment","1");
                answer_1.setText(String.valueOf(rand1));
                answer_1.setTextSize(40);
                answer_3.setText(String.valueOf(rand2));
                answer_3.setTextSize(40);
                answer_4.setText(String.valueOf(rand3));
                answer_4.setTextSize(40);

                break;
            case 2:
                Log.v("Assignment","2");
                answer_2.setText(String.valueOf(rand1));
                answer_2.setTextSize(40);

                answer_1.setText(String.valueOf(rand2));
                answer_1.setTextSize(40);
                answer_4.setText(String.valueOf(rand3));
                answer_4.setTextSize(40);

                break;
            case 3:
                Log.v("Assignment","3");
                answer_2.setText(String.valueOf(rand1));
                answer_2.setTextSize(40);
                answer_3.setText(String.valueOf(rand2));
                answer_3.setTextSize(40);
                answer_1.setText(String.valueOf(rand3));
                answer_1.setTextSize(40);

                break;
        }

    }

    public void startingTimer ( long mSeconds){

        final long timerIntervals = 1000;


        //initial the timer Class
        count = new CountDownTimer(mSeconds,timerIntervals) {
            @Override
            public void onTick(long millisUntilFinished) {

//                String timerString = String.valueOf(timerInMilliSeconds/1000);
//                timeCounter = Integer.valueOf(timerString);


                timer.setText(String.valueOf(millisUntilFinished/1000));

                timeCounter = Integer.valueOf(timer.getText().toString());
            }

            @Override
            public void onFinish() {
                isStarted= false;


                equation.setLayoutParams(new LinearLayout.LayoutParams(0,400,5f));
                equation.setGravity(Gravity.CENTER_VERTICAL);
                answer_1.setClickable(false);
                answer_2.setClickable(false);
                answer_3.setClickable(false);
                answer_4.setClickable(false);

                String finalScore = (String.valueOf(scoreNumber));

                timer.setText("0s");
//                int scoreInt = Integer.valueOf(scoreNumber);

//                StringBuilder grades = new StringBuilder();
//                grades.append("You Have Got  ");


//                if (scoreNumber <5){
//                    String s = getString(R.string.gradeC);
//                    grades.append(s);
//                    grades.append("\n Your Score = "+finalScore);
//                    equation.setText(grades);
//
//                }else if (scoreNumber >= 5 || scoreNumber<10){
//
//                    String s = getString(R.string.gradeB);
//                    grades.append(s);
//                    grades.append("\n Your Score = "+finalScore);
//                    equation.setText(grades);
//                }else if (scoreNumber >=10 || scoreNumber<=15 ){
//
//                    String s = getString(R.string.gradeA);
//                    grades.append(s);
//                    grades.append("\n Your Score = "+finalScore);
//                    equation.setText(grades);
//                }else {
//
//                    String s = getString(R.string.gradeAStar);
//                    grades.append(s);
//                    grades.append("\n Your Score = "+finalScore);
//                    equation.setText(grades);
//                }

                StringBuilder stringBuilder ;
                stringBuilder = calculatingGrades(scoreNumber);

                equation.setText(stringBuilder);

                timer.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);



            }
        }.start();

    }


    public StringBuilder calculatingGrades (int score){

        StringBuilder grades = new StringBuilder();
        if (score <0){
            return null;
        }

        if (score <5){
            String s = getString(R.string.gradeC);
            String sc = String.valueOf(score);
            grades.append(s);
            grades.append("\n \n Your Score = ");
            grades.append(sc);

            equation.setText(grades);

        }else if (scoreNumber >= 5 || scoreNumber<10){

            String s = getString(R.string.gradeB);
            String sc = String.valueOf(score);
            grades.append(s);
            grades.append("\n \n Your Score = ");
            grades.append(sc);
            equation.setText(grades);
        }else if (scoreNumber >=10 || scoreNumber<=15 ){

            String s = getString(R.string.gradeA);
            String sc = String.valueOf(score);
            grades.append(s);
            grades.append("\n \n Your Score = ");
            grades.append(sc);
            equation.setText(grades);
        }else {

            String s = getString(R.string.gradeAStar);
            String sc = String.valueOf(score);
            grades.append(s);
            grades.append("\n \n Your Score = ");
            grades.append(sc);
            equation.setText(grades);
        }
        return grades;
    }
}