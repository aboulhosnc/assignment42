package com.example.chady.assignment42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
            Intent i = new Intent(MainActivity.this, Results_Screen.class);
            startActivity(i);
        }
    }
}
