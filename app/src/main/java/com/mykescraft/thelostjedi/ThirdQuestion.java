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

public class ThirdQuestion extends AppCompatActivity {

    private int goodAnswer;
    private int chrystalCheckedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras!=null)
            goodAnswer = extras.getInt("adom");

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        RadioButton focusingLens = (RadioButton)findViewById(R.id.focusing_lens);
        focusingLens.setTypeface(myTypeFace);
        RadioButton chrystal = (RadioButton)findViewById(R.id.chrystal);
        chrystal.setTypeface(myTypeFace);
        RadioButton energyCell = (RadioButton)findViewById(R.id.energy_cell);
        energyCell.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);

    }

    public void rightThirdQuestion(View v) {
        RadioButton focusingLens = (RadioButton)findViewById(R.id.focusing_lens);
        RadioButton chrystal = (RadioButton)findViewById(R.id.chrystal);
        RadioButton energyCell = (RadioButton)findViewById(R.id.energy_cell);

        if (chrystal.isChecked()) {
            if(chrystalCheckedCount==0)
                goodAnswer++;

            nextToFourthQuestion(v, "adom", goodAnswer);

        }
        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            focusingLens.setChecked(false);
            chrystal.setChecked(false);
            energyCell.setChecked(false);
            chrystalCheckedCount++;
        }

    }

    private void nextToFourthQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, FourthQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}
