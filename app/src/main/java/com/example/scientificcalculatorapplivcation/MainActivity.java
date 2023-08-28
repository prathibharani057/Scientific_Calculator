package com.example.scientificcalculatorapplivcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.bt1);
        btn2=findViewById(R.id.bt2);


    }
    public void bttn1(View v)
    {
        Intent i=new Intent(this,calculator.class);
        startActivity(i);
    }
    public void conv(View v)
    {
        Intent i=new Intent(this,converter.class);
        startActivity(i);
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

}