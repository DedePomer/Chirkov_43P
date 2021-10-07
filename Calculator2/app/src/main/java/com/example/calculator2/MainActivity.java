package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean fnum=true, isPlus=false, isMinus = false, isDel= false, isUmn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);
        Button num0 = findViewById(R.id.num0);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button del = findViewById(R.id.del);
        Button umn = findViewById(R.id.umn);
        Button ravno = findViewById(R.id.ravno);
        Button clear = findViewById(R.id.clear);
        TextView textview = findViewById(R.id.textview);
        TextView textview2= findViewById(R.id.textview2);
        TextView textviewSum=findViewById(R.id.textviewSum);
        TextView textviewZnak=findViewById(R.id.textview3);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fnum=true;
                textview.setText("");
                textview2.setText("");
                textviewSum.setText("");
                textviewZnak.setText("");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                textviewZnak.append(button.getText());
                fnum=false;
                isPlus=true;
                isMinus = false;
                isDel= false;
                isUmn = false;
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                textviewZnak.append(button.getText());
                fnum=false;
                isPlus=false;
                isMinus = true;
                isDel= false;
                isUmn = false;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                textviewZnak.append(button.getText());
                fnum=false;
                isPlus=false;
                isMinus = false;
                isDel= true;
                isUmn = false;
            }
        });
        umn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                textviewZnak.append(button.getText());
                fnum=false;
                isPlus=false;
                isMinus = false;
                isDel= false;
                isUmn = true;
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="1";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="1";
                    textview2.setText(textview2_text);
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="2";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="2";
                    textview2.setText(textview2_text);
                }
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="3";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="3";
                    textview2.setText(textview2_text);
                }
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="4";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="4";
                    textview2.setText(textview2_text);
                }
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="5";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="5";
                    textview2.setText(textview2_text);
                }
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="6";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="6";
                    textview2.setText(textview2_text);
                }
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="7";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="7";
                    textview2.setText(textview2_text);
                }
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="8";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="8";
                    textview2.setText(textview2_text);
                }
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="9";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="9";
                    textview2.setText(textview2_text);
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(fnum){
                    String textview_text=textview.getText().toString();
                    textview_text+="0";
                    textview.setText(textview_text);
                }else{
                    String textview2_text=textview2.getText().toString();
                    textview2_text+="0";
                    textview2.setText(textview2_text);
                }
            }
        });
        ravno.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Integer textviewber=Integer.valueOf(textview.getText().toString());
                Integer textview2ber=Integer.valueOf(textview2.getText().toString());
                Integer summary=0;
                if (isPlus){
                    summary=textviewber+textview2ber;
                }
                else if(isMinus){
                    summary=textviewber-textview2ber;
                }
                else if(isDel){
                    summary=textviewber/textview2ber;
                }
                else if(isUmn){
                    summary=textviewber*textview2ber;
                }

                textviewSum.setText(summary.toString());
            }
        });

    }
}