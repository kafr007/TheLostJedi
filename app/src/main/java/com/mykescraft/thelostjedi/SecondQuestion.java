package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Csimpi on 2017.12.10..
 */

public class SecondQuestion extends AppCompatActivity {
    int goodAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras!=null)
            goodAnswer = extras.getInt("adom");

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        RadioButton blue = (RadioButton)findViewById(R.id.blue);
        blue.setTypeface(myTypeFace);
        RadioButton red = (RadioButton)findViewById(R.id.red);
        red.setTypeface(myTypeFace);
        RadioButton green = (RadioButton)findViewById(R.id.green);
        green.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);

    }

    public void rightSecondQuestion(View v) {
        RadioButton blue = (RadioButton)findViewById(R.id.blue);
        RadioButton red = (RadioButton)findViewById(R.id.red);
        RadioButton green = (RadioButton)findViewById(R.id.green);
        int lukeLightSaberCheckedCount = 0;
        if (green.isChecked()) {

            ++lukeLightSaberCheckedCount;
           if(lukeLightSaberCheckedCount==1)
                goodAnswer++;
            nextToThirdQuestion(v, "adom", goodAnswer);


        }
        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            blue.setChecked(false);
            red.setChecked(false);
            green.setChecked(false);
        }

    }

    private void nextToThirdQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, ThirdQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}
