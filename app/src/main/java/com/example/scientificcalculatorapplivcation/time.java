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

public class time extends AppCompatActivity {
    EditText et;
    TextView t1;
    Button b1,b2;

    String[] item={"Second->Minute","Minute->Second","Minute->Hour","Hour->Minute","Second->Hour","Hour->Second"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

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
            case "Second->Minute":
                sm(v);
                break;
            case "Minute->Second":
                ms(v);
                break;
            case "Second->Hour":
                sh(v);
                break;
            case "Hour->Second":
                hs(v);
                break;
            case "Minute->Hour":
                mh(v);
                break;
            case "Hour->Minute":
                hm(v);
                break;
            default:
                Toast.makeText(this, "Please choose units to convert", Toast.LENGTH_LONG).show();
        }
    }
    public void  sm(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/60;
            String r=String.valueOf(b);
            t1.setText(r+"minutes");

        }

    }
    public void  ms(View v)
    {
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*60;
            String r=String.valueOf(b);
            t1.setText(r+"seconds");

        }

    }

    public void sh(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=(a/60)/60;
            String r=String.valueOf(b);
            t1.setText(r+"hours");

        }

    }

    public void hs(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=(a*60)*60;
            String r=String.valueOf(b);
            t1.setText(r+"seconds");

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

    public void mh(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a/60;
            String r=String.valueOf(b);
            t1.setText(r+"hours");

        }

    }
    public void hm(View v){
        if(et.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show();
        }
        else {
            Double a=Double.parseDouble(String.valueOf(et.getText()));
            Double b=a*60;
            String r=String.valueOf(b);
            t1.setText(r+"minutes");
        }
    }

    public void back(View v)
    {

        finish();

    }




}