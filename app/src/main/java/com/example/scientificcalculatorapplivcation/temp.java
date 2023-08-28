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

public class temp extends AppCompatActivity {
    EditText et;
    TextView t1;
    Button b1,b2;

    String[] item={"Celcius->Fahrenheit","Fahrenheit->Celcius","Celcius->Kelvin","Kelvin->Celcius","Kelvin->Fahrenheit","Fahrenheit->Kelvin"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,item);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(temp.this," "+item,Toast.LENGTH_LONG).show();
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
    public void conv(View v)
    {
        String unit=autoCompleteTextView.getText().toString();
        switch(unit){
            case "Celcius->Fahrenheit":cf(v);break;
            case "Fahrenheit->Celcius":fc(v);break;
            case "Celcius->Kelvin":ck(v);break;
            case "Kelvin->Celcius":kc(v);break;
            case "Kelvin->Fahrenheit":kf(v);break;
            case "Fahrenheit->Kelvin":fk(v);break;
            default:Toast.makeText(this,"Please choose units to convert",Toast.LENGTH_LONG).show();
        }
    }
    public void  cf(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter the temperature",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*9/5+32;
            String r=String.valueOf(b);
            t1.setText(r+"°F");

        }

    }
    public void  fc(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter the temperature",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=(a-32)/1.8;
            String r=String.valueOf(b);
            t1.setText(r+"°C");

        }

    }

    public void ck(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter the temperature",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a+273.15;
            String r=String.valueOf(b);
            t1.setText(r+"K");

        }

    }

    public void kc(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter the temperature",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));

            Double b=a-273.15;
            String r=String.valueOf(b);
            t1.setText(r+"°C");

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

    public void kf(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter the temperature",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=(a-273.15)*(9/5)+32;
            //Double b=a*-457.87;
            String r=String.valueOf(b);
            t1.setText(r+"°F");

        }

    }
    public void fk(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter the temperature",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=(a-32)*(5/9)+273.15;
            String r=String.valueOf(b);
            t1.setText(r+"°K");
        }
}

    public void back1(View v)
    {

        finish();

    }






}