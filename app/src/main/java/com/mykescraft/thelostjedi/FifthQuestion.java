package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Csimpi on 2017.12.10..
 */

public class FifthQuestion extends AppCompatActivity {

    private int goodAnswer;
    private int sevenCheckedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras!=null)
            goodAnswer = extras.getInt("adom");

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        RadioButton five = (RadioButton)findViewById(R.id.five);
        five.setTypeface(myTypeFace);
        RadioButton seven = (RadioButton)findViewById(R.id.seven);
        seven.setTypeface(myTypeFace);
        RadioButton nine = (RadioButton)findViewById(R.id.nine);
        nine.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);

    }

    public void rightFifthQuestion(View v) {
        RadioButton five = (RadioButton)findViewById(R.id.five);
        RadioButton seven = (RadioButton)findViewById(R.id.seven);
        RadioButton nine = (RadioButton)findViewById(R.id.nine);

        if (seven.isChecked()) {
            if(sevenCheckedCount==0)
                goodAnswer++;

            nextToSixthQuestion(v, "adom", goodAnswer);
        }
        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            five.setChecked(false);
            seven.setChecked(false);
            nine.setChecked(false);
            sevenCheckedCount++;
        }

    }

    private void nextToSixthQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, SixthQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}