package com.example.scientificcalculatorapplivcation;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mass extends AppCompatActivity {
    EditText et;
    TextView t1;
    Button b1,b2;

    String[] item={"Gram->Killogram","Kilogram->Gram","Gram->Milligram","Milligram->Gram","Gram->Pound","Pound->Gram"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(mass.this," "+item,Toast.LENGTH_LONG).show();
            }
        });

        et=findViewById(R.id.edt);
        t1=findViewById(R.id.txt1);

        //b1=findViewById(R.id.f);
        b2=findViewById(R.id.c);
    }
    public void num(View v)
    {
        Button b=(Button) v;
        String s=(String)b.getText();
        et.append(s);

    }
    public void conv(View v) {
        String unit = autoCompleteTextView.getText().toString();
        switch (unit) {
            case "Gram->Killogram":
                gk(v);
                break;
            case "Kilogram->Gram":
                kg(v);
                break;
            case "Gram->Milligram":
                gm(v);
                break;
            case "Milligram->Gram":
                mg(v);
                break;
            case "Gram->Pound":
                gp(v);
                break;
            case "Pound->Gram":
                pg(v);
                break;
            default:
                Toast.makeText(this, "Please choose units to convert", Toast.LENGTH_LONG).show();
        }
    }
    public void  gk(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/1000;
            String r=String.valueOf(b);
            t1.setText(r+"kg");

        }

    }
    public void  kg(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*1000;
            String r=String.valueOf(b);
            t1.setText(r+"g");

        }

    }

    public void gm(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*1000;
            String r=String.valueOf(b);
            t1.setText(r+"mg");

        }

    }

    public void mg(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/1000;
            String r=String.valueOf(b);
            t1.setText(r+"g");

        }

    }

    public  void all_cleraed(View v)
    {
        et.setText("");
        t1.setText("");
    }
    public void clear_one_digit(View v)
    {

        if(et.hasFocus())
        {
            String n;
            n=et.getText().toString();
            n=n.substring(0,n.length()-1);
            et.setText(n);
        }

        else
            Toast.makeText(this, "Please get the focus on  field", Toast.LENGTH_LONG).show();

    }

    public void gp(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/453.592;
            String r=String.valueOf(b);
            t1.setText(r+"lb");

        }

    }
    public void pg(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*453.592;
            String r=String.valueOf(b);
            t1.setText(r+"g");
        }
    }

    public void back(View v)
    {

        finish();

    }




}