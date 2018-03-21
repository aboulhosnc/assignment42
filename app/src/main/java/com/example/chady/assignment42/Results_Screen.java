package com.example.chady.assignment42;

import android.app.Activity;
import android.os.Bundle;
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


}
