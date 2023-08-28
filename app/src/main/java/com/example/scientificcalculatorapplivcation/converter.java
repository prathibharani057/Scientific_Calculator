package com.example.scientificcalculatorapplivcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class converter extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);


    }

    public void temp(View v)
    {
        Intent i=new Intent(this,temp.class);
        startActivity(i);
    }

    public void length(View v)
    {
        Intent i=new Intent(this,length.class);
        startActivity(i);
    }

    public void mass(View v)
    {
        Intent i=new Intent(this,mass.class);
        startActivity(i);
    }

    public void area(View v)
    {
        Intent i=new Intent(this,area.class);
        startActivity(i);
    }
    public void time(View v)
    {
        Intent i=new Intent(this,time.class);
        startActivity(i);
    }
    public void num(View v)
    {
        Intent i=new Intent(this,num.class);
        startActivity(i);
    }
    public void back(View v)
    {

        finish();
    }

}