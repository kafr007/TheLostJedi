package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Csimpi on 2017.12.10..
 */

public class SeventhQuestion extends AppCompatActivity {
    int goodAnswer;
    int allCheckedCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        if (extras!=null)
            goodAnswer = extras.getInt("adom");

        Typeface myTypeFace = Typeface.createFromAsset(getAssets(),
                "font/deathstar.otf");
        CheckBox head = (CheckBox)findViewById(R.id.head);
        head.setTypeface(myTypeFace);
        CheckBox leftArm = (CheckBox)findViewById(R.id.left_arm);
        leftArm.setTypeface(myTypeFace);
        CheckBox rightArm = (CheckBox)findViewById(R.id.right_arm);
        rightArm.setTypeface(myTypeFace);
        CheckBox back = (CheckBox)findViewById(R.id.back);
        back.setTypeface(myTypeFace);
        CheckBox leftLeg = (CheckBox)findViewById(R.id.left_leg);
        leftLeg.setTypeface(myTypeFace);
        CheckBox rightLeg = (CheckBox)findViewById(R.id.right_leg);
        rightLeg.setTypeface(myTypeFace);
        Button next = (Button)findViewById(R.id.button_next);
        next.setTypeface(myTypeFace);

    }

    public void rightSeventhQuestion(View v) {
        CheckBox head = (CheckBox)findViewById(R.id.head);
        CheckBox leftArm = (CheckBox)findViewById(R.id.left_arm);
        CheckBox rightArm = (CheckBox)findViewById(R.id.right_arm);
        CheckBox back = (CheckBox)findViewById(R.id.back);
        CheckBox leftLeg = (CheckBox)findViewById(R.id.left_leg);
        CheckBox rightLeg = (CheckBox)findViewById(R.id.right_leg);


        if (head.isChecked() && leftArm.isChecked() && rightArm.isChecked() && back.isChecked() && leftLeg.isChecked() && rightLeg.isChecked()) {
            if(allCheckedCount==0)
                goodAnswer++;
            nextToLastView(v, "adom", goodAnswer);


        }
        else {
            Toast.makeText(this,"Sorry, this is not the correct answer. Try it again!", Toast.LENGTH_SHORT).show();
            head.setChecked(false);
            leftArm.setChecked(false);
            rightArm.setChecked(false);
            back.setChecked(false);
            leftLeg.setChecked(false);
            rightLeg.setChecked(false);
            allCheckedCount++;
        }

    }

    private void nextToLastView(View v, String name, int value) {
        Intent intent = new Intent(this, LastActivity.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}