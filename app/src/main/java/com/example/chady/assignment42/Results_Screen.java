package com.example.chady.assignment42;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Chady on 3/21/2018.
 */

public class Results_Screen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_screen);

        //String  pairMatchResult = getIntent().getStringExtra("")

        String wordMatch =getIntent().getStringExtra("UserWordCheck");

        TextView tv = (TextView)findViewById(R.id.TVmatchresults);
        tv.setText(wordMatch);

    }

    public void onHomeClick(View v)
    {
        if(v.getId() == R.id.BHome)
        {
            Intent i = new Intent(Results_Screen.this, MainActivity.class);
            startActivity(i);
        }
    }


}
