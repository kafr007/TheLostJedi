package com.mykescraft.thelostjedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Csimpi on 2017.12.10..
 */

public class LastActivity extends AppCompatActivity {
    int goodAnswer;
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
            percent.setTypeface(myTypeFace);
            percent.setText("" + ((goodAnswer/7)*100) + "%");
        }


        Button restart = (Button)findViewById(R.id.button_restart);
        restart.setTypeface(myTypeFace);



    }

   public void restart(View v){
       Intent intent = new Intent(this, FirstQuestion.class);
       startActivity(intent);

    }




}