package com.example.chady.assignment42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEnterValueClick(View v)
    {
       if(v.getId() == R.id.Benter_values)
       {
           Intent i = new Intent(MainActivity.this, Enter_Values.class);
           startActivity(i);
       }
    }

    public void onFindClick (View v)
    {
        if(v.getId() == R.id.Bfind_match)
        {
            // word in id  plain text field
            EditText a = (EditText)findViewById(R.id.TFmatch);
            String userWord  = a.getText().toString();

            // pulls word from database
            //String userWordDatabase = helper.searchUserWord(userWord);



            if(userWord.length() >= 1)
            {

                String userWordResultDatabase = helper.searchUserWord(userWord);

                Intent i = new Intent(MainActivity.this, Results_Screen.class);

                i.putExtra("UserWordCheck", userWordResultDatabase);
                startActivity(i);
            }

            // if  word the user enters is not on the list then
            // on the results page display a result not found
            else
            {

                Toast wordNotFound = Toast.makeText(MainActivity.this, "Need to enter  text !" , Toast.LENGTH_SHORT);
                wordNotFound.show();
            }


        }




    }
}
