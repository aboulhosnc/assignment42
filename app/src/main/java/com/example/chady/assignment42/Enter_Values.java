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

            //checks if user entered anything into user word field
            if(userWordstr.length() ==0)
            {
                Toast userWordOriginal = Toast.makeText(Enter_Values.this, "Original word not entered into field!" , Toast.LENGTH_SHORT);
                userWordOriginal.show();
            }
            //checks if user entered in any word into antonym word field
            else if(userWordMatchstr.length() == 0)
            {
                Toast userAntonym = Toast.makeText(Enter_Values.this, "Antonym not entered into field !" , Toast.LENGTH_SHORT);
                userAntonym.show();
            }
            else
            {
                //insert details into database
                AntonymList a = new AntonymList();

                a.setUserWord(userWordstr);
                a.setUserAntonym(userWordMatchstr);

                // user inserts word pair into database
                helper.insertAntonym(a);


                // button goes back to main menu
                Intent i = new Intent( Enter_Values.this, MainActivity.class);
                startActivity(i);

            }

        }
    }




}
