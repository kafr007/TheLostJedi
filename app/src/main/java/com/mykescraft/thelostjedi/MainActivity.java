package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int goodAnswerFirst = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set typeface
        Typeface mtypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        Button ok = (Button)findViewById(R.id.button_ok);
        ok.setTypeface(mtypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(mtypeFace);
    }
    //ok button click
    public void ok(View v){
        TextView introduction = (TextView) findViewById(R.id.introduction);
        String name = ((EditText)findViewById(R.id.name_edit_text)).getText().toString();
        String introductionText = "Hello " + name + " Padawan!\nYou\'ve lost in a dark forest. You have to answer 7 questions correctly and you will find your way out of the forest. \nYou\'re Master will evaluate your performance. It is a good answer, if you give it for the first time. \nLet\'s start it!\nMay the force be with you!";
        introduction.setText(introductionText);
        introduction.setTextColor(Color.parseColor("#FFD700"));
    }

    public void nextToFirstQuestion(View v){
        Intent intent = new Intent(this, FirstQuestion.class);
        startActivity(intent);
           }
}
