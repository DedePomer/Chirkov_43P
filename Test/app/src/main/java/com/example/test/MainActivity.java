package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
TextView T, test;
Integer firstNUmber = 0;
    Integer secondnumber = 0;
    String fN="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T = (TextView) findViewById(R.id.text);
        test = (TextView) findViewById(R.id.textTest);

    }
public void onNumberClick (View view)
{
    Button button = (Button) view;
    T.append(button.getText());
}

    public void onClicDel (View view)
    {
        T.setText(" ");
    }
    public void onClicZ (View view)
    {

            Button button = (Button) view;

            /*if( button.getText().equals("="))
            {T.append(button.getText());}
            else
            {
                String str =  T.getText().toString();
            firstNUmber = Integer.parseInt(str);
            test.setText(String.valueOf(firstNUmber));
        }*/
       if(button.getText().equals("="))
        {
            String str =  T.getText().toString();
            secondnumber = Integer.valueOf(str.substring(str.length()-1));
            test.setText(String.valueOf(secondnumber));
            T.append(button.getText());
            switch (fN)
            {
                case "+":
                {
                    firstNUmber+= secondnumber;
                    T.append(String.valueOf(firstNUmber));
                    break;
                }
            }
}
        else
    {
        firstNUmber = Integer.valueOf(T.getText().toString());
        T.append(button.getText());
        fN =  T.getText().toString();
        fN = fN.substring(fN.length() - 1);
        test.setText(String.valueOf(firstNUmber));
    }

    }
}


