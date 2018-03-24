package com.example.chady.assignment42;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chady on 3/21/2018.
 */

public class Enter_Values extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

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
            //Intent j = new Intent(Enter_Values.this, MainActivity.class);
            //startActivity(j);

            // pulls in text from keyboard in text area
            EditText userWord = (EditText)findViewById(R.id.TFuserWord);
            EditText userWordMatch = (EditText)findViewById(R.id.TFuserWordMatch);

            // Converts  input from text field to a string
            String userWordstr = userWord.getText().toString();
            String userWordMatchstr = userWordMatch.getText().toString();

            //checks if two words are a match
            if(!userWordstr.equals(userWordMatchstr))
            {
                Toast wordNotFound = Toast.makeText(Enter_Values.this, "The user word and the antonym do not match !" , Toast.LENGTH_SHORT);
                wordNotFound.show();
            }
            else
            {
                //insert details into database
                AntonymList c = new AntonymList();

                c.setUserWord(userWordstr);
                c.setUserAntonym(userWordMatchstr);

                helper.insertAntonym(c);

            }

        }
    }




}
