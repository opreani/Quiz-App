package com.timibz.quizapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.timibz.quizapp.MESSAGE";
    private Questions myQuestionLib = new Questions();

    private TextView Total;
    private TextView Question;
    private Button Button1;
    private Button Button2;
    private Button Button3;

    private String Answer;
    private int Score = 0;
    private int currentQuestion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_main);

        Total = (TextView)findViewById(R.id.score);
        Question = (TextView)findViewById(R.id.question);
        Button1 = (Button) findViewById(R.id.button2);
        Button2 = (Button) findViewById(R.id.button3);
        Button3 = (Button) findViewById(R.id.button4);

        updateQuestion();


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button1.getText() == Answer){
                    Score+=1;
                    updateScore(Score);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button2.getText() == Answer){
                    Score+=1;
                    updateScore(Score);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Button3.getText() == Answer){
                    Score+=1;
                    updateScore(Score);
                    updateQuestion();
                    Toast.makeText(MainActivity.this, "CORRECT", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "WRONG", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
    }

    /** This method is called when all the questions have been answered*/

    public void updateQuestion(){
        if(currentQuestion == 10){
            Intent intent = new Intent(this, DisplayMessage.class);
            TextView editText = (TextView) findViewById(R.id.score);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
            return;
        }
        Question.setText(myQuestionLib.getQuestion(currentQuestion));
        Button1.setText(myQuestionLib.getChoice1(currentQuestion));
        Button2.setText(myQuestionLib.getChoice2(currentQuestion));
        Button3.setText(myQuestionLib.getChoice3(currentQuestion));

        Answer = myQuestionLib.getCorrectanswer(currentQuestion);
        currentQuestion++;
    }

    public void updateScore(int point){
        Total.setText(""+Score);
    }

    /** Called when the user taps the Main Menu button */

    public void mainMenu(View view) {
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
    }

}