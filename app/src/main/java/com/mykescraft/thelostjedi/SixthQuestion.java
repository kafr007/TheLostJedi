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

public class SixthQuestion extends AppCompatActivity {
    int goodAnswer;
    int kitFistoCheckedCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras!=null)
            goodAnswer = extras.getInt("adom");

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        RadioButton kitFisto = (RadioButton)findViewById(R.id.kit_fisto);
        kitFisto.setTypeface(myTypeFace);
        RadioButton maceWindu = (RadioButton)findViewById(R.id.mace_windu);
        maceWindu.setTypeface(myTypeFace);
        RadioButton ploKoon = (RadioButton)findViewById(R.id.plo_koon);
        ploKoon.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);

    }

    public void rightSixthQuestion(View v) {
        RadioButton kitFisto = (RadioButton)findViewById(R.id.kit_fisto);
        RadioButton maceWindu = (RadioButton)findViewById(R.id.mace_windu);
        RadioButton ploKoon = (RadioButton)findViewById(R.id.plo_koon);

        if (kitFisto.isChecked()) {
            if(kitFistoCheckedCount==0)
                goodAnswer++;
            nextToSeventhQuestion(v, "adom", goodAnswer);

        }
        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            kitFisto.setChecked(false);
            maceWindu.setChecked(false);
            ploKoon.setChecked(false);
            kitFistoCheckedCount++;
        }

    }

    private void nextToSeventhQuestion(View v, String name, int value) {
        Intent intent = new Intent(this, SeventhQuestion.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}