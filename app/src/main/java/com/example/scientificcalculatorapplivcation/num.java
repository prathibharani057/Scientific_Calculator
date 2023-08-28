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

import java.util.Locale;

public class num extends AppCompatActivity {
    EditText et;
    TextView t1;
    Button b1,b2;

    String[] item={"Integer->Binary","Binary->Integer","Integer->Octal","Octal->Integer","Integer->Hexadecimal","Hexadecimal->Integer"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);

        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(time.this," "+item,Toast.LENGTH_LONG).show();
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
            case "Integer->Binary":
                ib(v);
                break;
            case "Integer->Octal":
                io(v);
                break;
            case "Integer->Hexadecimal":
                ih(v);
                break;
            case "Binary->Integer":
                bi(v);
                break;
            case "Octal->Integer":
                oi(v);
                break;
            case "Hexadecimal->Integer":
                hi(v);
                break;
            default:
                Toast.makeText(this, "Please choose units to convert", Toast.LENGTH_LONG).show();
        }
    }
    public void  ib(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            String a=String.valueOf(et.getText());
            String b=Integer.toBinaryString(Integer.parseInt(a));
            String r=String.valueOf(b);
            t1.setText(b);

        }

    }
    public void  io(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            String a=String.valueOf(et.getText());
            String b=Integer.toOctalString(Integer.parseInt(a));
            String r=String.valueOf(b);
            t1.setText(b);

        }

    }

    public void ih(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            String a=String.valueOf(et.getText());
            String b=Integer.toHexString(Integer.parseInt(a));
            String r=String.valueOf(b.toUpperCase());
            t1.setText(r);

        }

    }

    public void bi(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            String a=String.valueOf(et.getText());
            int b=Integer.parseInt(a,2);
            String r=String.valueOf(b);
            t1.setText(r);

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

    public void hi(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            String a=String.valueOf(et.getText());
            int b=Integer.parseInt(a,16);
            String r=String.valueOf(b);
            t1.setText(r);

        }

    }
    public void oi(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            String a=String.valueOf(et.getText());
            int b=Integer.parseInt(a,8);
            String r=String.valueOf(b);
            t1.setText(r);
        }
    }

    public void back(View v)
    {

        finish();

    }




}