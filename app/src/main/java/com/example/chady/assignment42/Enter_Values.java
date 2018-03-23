package com.example.chady.assignment42;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chady on 3/21/2018.
 */

public class Enter_Values extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);




    }


    public void onEnterValueClick (View v)
    {
        if(v.getId() == R.id.BsubmitWordPair)
        {
            EditText  userword = (EditText)findViewById(R.id.TFuserWord);
            EditText  wordmatch =(EditText)findViewById(R.id.TFwordMatch);

            String userwordstr = userword.getText().toString();
            String wordmatchstr = wordmatch.getText().toString();

            if(!userwordstr.equals(wordmatchstr))
            {
                //popup msg
                Toast wordNotMatch = Toast.makeText(Enter_Values.this, "User Word and Antonym do not match!" , Toast.LENGTH_SHORT);
                wordNotMatch.show();
            }

        }
    }


}
