package com.example.MyApplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculator.databinding.ActivityMainBinding;import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    TextView T;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T = (TextView) findViewById(R.id.INOUTtext);
    }
    public void onNumberClick(View view)
    {
        Button button = (Button) view;
        T.append(button.getText());
    }

    public void onOperationClick(View view)
    {
        Button button = (Button)view;
        String op = T.getText().toString();
        Integer a = 0;
        if(  button.getText() == "=")
        {
            op.valueOf(a);
            T.append(a.toString());
        }
    }

    public void onDeleteClick(View view)
    {
        String number = T.getText().toString();
        if(number != "")
        {
            T.setText(number.substring(0,number.length()-1));
        }
    }



}