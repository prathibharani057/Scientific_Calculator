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

public class length extends AppCompatActivity {
    EditText et;
    TextView t1;
    Button b1,b2;

    String[] item={"Centimeter->Meter","Meter->Centimeter","Meter->Kilometer","Kilometer->Meter","Centimeter->Millimeter","Millimeter->Centimeter"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(length.this," "+item,Toast.LENGTH_LONG).show();
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
            case "Centimeter->Meter":
                cm(v);
                break;
            case "Meter->Centimeter":
                mc(v);
                break;
            case "Meter->Kilometer":
                mk(v);
                break;
            case "Kilometer->Meter":
                km(v);
                break;
            case "Centimeter->Millimeter":
                cmm(v);
                break;
            case "Millimeter->Centimeter":
                mmc(v);
                break;
            default:
                Toast.makeText(this, "Please choose units to convert", Toast.LENGTH_LONG).show();
        }
    }
    public void  cm(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/100;
            String r=String.valueOf(b);
            t1.setText(r+"m");

        }

    }
    public void  mc(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*100;
            String r=String.valueOf(b);
            t1.setText(r+"cm");

        }

    }

    public void mk(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/1000;
            String r=String.valueOf(b);
            t1.setText(r+"km");

        }

    }

    public void km(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*1000;
            String r=String.valueOf(b);
            t1.setText(r+"m");

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

    public void cmm(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*10;
            String r=String.valueOf(b);
            t1.setText(r+"mm");

        }

    }
    public void mmc(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/10;
            String r=String.valueOf(b);
            t1.setText(r+"cm");
        }
    }

    public void back(View v)
    {

        finish();

    }
}