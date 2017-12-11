package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.Console;

public class FirstQuestion extends AppCompatActivity {
    public int goodAnswerFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Intent intent = getIntent();

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        RadioButton jediKnight = (RadioButton)findViewById(R.id.jedi_knight);
        jediKnight.setTypeface(myTypeFace);
        RadioButton jediConsular = (RadioButton)findViewById(R.id.jedi_consular);
        jediConsular.setTypeface(myTypeFace);
        RadioButton jediSentinel = (RadioButton)findViewById(R.id.jedi_sentinel);
        jediSentinel.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);



    }

    public void rightFirstQuestion(View v) {
        RadioButton jediKnight = (RadioButton)findViewById(R.id.jedi_knight);
        RadioButton jediConsular = (RadioButton)findViewById(R.id.jedi_consular);
        RadioButton jediSentinel = (RadioButton)findViewById(R.id.jedi_sentinel);
        int jediKnightCheckedCount = 0;
        if (jediKnight.isChecked()) {
            ++jediKnightCheckedCount;
            if(jediKnightCheckedCount==1)
                goodAnswerFirst++;

            nextToSecondQuestion(v, "adom", goodAnswerFirst);

        }

        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            jediConsular.setChecked(false);
            jediKnight.setChecked(false);
            jediSentinel.setChecked(false);
        }

    }

    private void nextToSecondQuestion(View v, String name, int value){
        Intent intent = new Intent(this, SecondQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);

    }


}


