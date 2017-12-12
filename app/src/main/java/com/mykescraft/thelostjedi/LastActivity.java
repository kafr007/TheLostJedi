package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Csimpi on 2017.12.10..
 */

public class LastActivity extends AppCompatActivity {

    private int goodAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_last);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        if (extras!=null) {
            goodAnswer = extras.getInt("adom");
            TextView percent = (TextView)findViewById(R.id.percent);
            double result = goodAnswer/7.0*100.0;
            String result1 = String.format("%2f", result);
            percent.setText("" + result1 + "%");

            if (result>=0)
                setTextEvaluation("My Padawan, I see you tried it, but you have to practice lot more to become a Jedi Master one day.", "red");


            if (result>30)
                setTextEvaluation("My Padawan, I see you tried it, but you have to practice more to become a Jedi Master one day.", "red");


            if (result>60)
                setTextEvaluation("My Padawan, I'am proud of you, you have to practice more, but you become a Jedi Master soon.", "black");

            if (result>80)
                setTextEvaluation("My Padawan, I'am very proud of you. You become a Jedi Master very soon.", "green");

        }



        Button restart = (Button)findViewById(R.id.button_restart);
        restart.setTypeface(myTypeFace);



    }

    private void setTextEvaluation(String advice, String colorOfText){
        TextView evaluation = (TextView)findViewById(R.id.evaluation);
        evaluation.setText(advice);
        evaluation.setTextColor(Color.parseColor(colorOfText));
    }

   public void restart(View v){
       Intent intent = new Intent(this, FirstQuestion.class);
       startActivity(intent);

    }




}