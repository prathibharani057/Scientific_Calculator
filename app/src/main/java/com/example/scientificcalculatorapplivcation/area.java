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

public class area extends AppCompatActivity {
    EditText et;
    TextView t1;
    Button b1,b2;

    String[] item={"Meter²>Centimeter²","Centimeter²->Meter²","Meter²->Feet²","Feet²->Meter²","Meter²->Kilometer²","Meter->Inch²"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(area.this," "+item,Toast.LENGTH_LONG).show();
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
            case "Meter²>Centimeter²":
                mc(v);
                break;
            case "Centimeter²->Meter²":
                cm(v);
                break;
            case "Meter²->Feet²":
                mf(v);
                break;
            case "Feet²->Meter²":
                fm(v);
                break;
            case "Meter²->Kilometer²":
                mk(v);
                break;
            case "Meter->Inch²":
                mi(v);
                break;
            default:
                Toast.makeText(this, "Please choose units to convert", Toast.LENGTH_LONG).show();
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
            Double b=a*10000;
            String r=String.valueOf(b);
            t1.setText(r+"cm²");

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
            Double b=a/10000;
            String r=String.valueOf(b);
            t1.setText(r+"m²");

        }

    }

    public void mf(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));

            Double b=a/0.09290304;
            String r=String.valueOf(b);
            t1.setText(r+"ft²");

        }

    }

    public void fm(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*0.09290304;
            String r=String.valueOf(b);
            t1.setText(r+"m²");

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

    public void mk(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*1000000;
            String r=String.valueOf(b);
            t1.setText(r+"km²");

        }

    }
    public void mi(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*0.00064516;
            String r=String.valueOf(b);
            t1.setText(r+"in²");
        }
    }

    public void back(View v)
    {

        finish();
    }




}