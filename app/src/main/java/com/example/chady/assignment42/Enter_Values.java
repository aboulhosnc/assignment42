package com.example.chady.assignment42;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Chady on 3/21/2018.
 */

public class Enter_Values extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);

        //String  pairMatchResult = getIntent().getStringExtra("")


    }


    public void onSubmitClick (View v)
    {
        if(v.getId() == R.id.Bwordsubmit)
        {
            Intent j = new Intent(Enter_Values.this, MainActivity.class);
            startActivity(j);
        }
    }


}
