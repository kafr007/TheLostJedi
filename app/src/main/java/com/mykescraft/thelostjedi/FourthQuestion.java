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

public class FourthQuestion extends AppCompatActivity {
    private int goodAnswer;
    private int shiiChoCheckedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras!=null)
            goodAnswer = extras.getInt("adom");
        //set fonttype
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        RadioButton ataru = (RadioButton)findViewById(R.id.ataru);
        ataru.setTypeface(myTypeFace);
        RadioButton shiiCho = (RadioButton)findViewById(R.id.shii_cho);
        shiiCho.setTypeface(myTypeFace);
        RadioButton makashi = (RadioButton)findViewById(R.id.makashi);
        makashi.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);
    }

    public void rightFourthQuestion(View v) {
        RadioButton ataru = (RadioButton)findViewById(R.id.ataru);
        RadioButton shiiCho = (RadioButton)findViewById(R.id.shii_cho);
        RadioButton makashi = (RadioButton)findViewById(R.id.makashi);
        if (shiiCho.isChecked()) {
           if(shiiChoCheckedCount==0)
                    goodAnswer++;
            nextToFifthQuestion(v, "adom", goodAnswer);
        }
        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            ataru.setChecked(false);
            shiiCho.setChecked(false);
            makashi.setChecked(false);
            shiiChoCheckedCount++;
        }
    }

    private void nextToFifthQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, FifthQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}