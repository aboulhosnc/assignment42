package com.example.chady.assignment42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// button to get to enter values screen
    public void onEnterValueClick(View v)
    {
       if(v.getId() == R.id.Benter_values)
       {
           Intent i = new Intent(MainActivity.this, Enter_Values.class);
           startActivity(i);
       }
    }

// button to get to results screen
    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.Bwordmatch)
        {
            EditText a = (EditText)findViewById(R.id.TFmatch);
            String str = a.getText().toString();

            //adds word in text field to results  screen
            Intent i = new Intent(MainActivity.this, Results_Screen.class);
            i.putExtra("UserWordCheck", str);
            startActivity(i);
        }






    }
}
