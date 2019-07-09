package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TypeConverter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.function.ToIntFunction;

public class MainActivity extends AppCompatActivity {

    //variables
    String for_screen = "";
    String first_value="";
    String second_value="";
    String operator="";
    int result=0;
    Boolean operator_check=false;
    //components variables
    EditText input_screen,result_screen;
    Button clear,modulus,divide,add,minus,multiply,equal,backspace,zero,dot,one,two,three,four,five,six,seven,eight,nine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //all Id variables
        input_screen = findViewById(R.id.inputScreen);
        result_screen=findViewById(R.id.resultScreen);
        clear=findViewById(R.id.clearBtn);
        modulus=findViewById(R.id.modulusBtn);
        divide=findViewById(R.id.divideBtn);
        add=findViewById(R.id.addBtn);
        minus=findViewById(R.id.minusBtn);
        multiply=findViewById(R.id.multiplyBtn);
        equal=findViewById(R.id.equalBtn);
        backspace=findViewById(R.id.backspace);
        zero=findViewById(R.id.zeroBtn);
        dot=findViewById(R.id.dotBtn);
        one=findViewById(R.id.oneBtn);
        two=findViewById(R.id.twoBtn);
        three=findViewById(R.id.threeBtn);
        four=findViewById(R.id.fourBtn);
        five=findViewById(R.id.fiveBtn);
        six=findViewById(R.id.sixBtn);
        seven=findViewById(R.id.sevenBtn);
        eight=findViewById(R.id.eightBtn);
        nine=findViewById(R.id.nineBtn);

        //OnClick functions

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(0);
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(for_screen.length()>1){
                    for_screen = for_screen.substring(0,for_screen.length()-1);
                    input_screen.setText(for_screen);
                }else{
                    for_screen="";
                    input_screen.setText("0");
                }

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInput(9);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_screen.setText("0");
                for_screen="";
                first_value="";
                second_value="";
                operator="";
                result=0;
            }
        });
        modulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator_check==false){
                    first_value = input_screen.getText().toString();
                    operator="%";
                    input_screen.setText("0");
                    for_screen="";
                    operator_check=true;
                    if(result!=0){
                        second_value =first_value;
                        first_value = String.valueOf(result);
                        result=Integer.valueOf(first_value)%Integer.valueOf(second_value);
                        result_screen.setText(String.valueOf(result));
                        operator_check=false;
                    }
                }else{
                    operator_check = false;
                    operator="%";
                    second_value = input_screen.getText().toString();
                    result = Integer.valueOf(first_value)%Integer.valueOf(second_value);
                    input_screen.setText("0");
                    for_screen="";
                    result_screen.setText(String.valueOf(result));
                }


            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(operator_check==false){
                    first_value = input_screen.getText().toString();
                    operator="/";
                    input_screen.setText("0");
                    for_screen="";
                    operator_check=true;
                    if(result!=0){
                        second_value =first_value;
                        first_value = String.valueOf(result);
                        result=Integer.valueOf(first_value)/Integer.valueOf(second_value);
                        result_screen.setText(String.valueOf(result));
                        operator_check=false;
                    }
                }else{
                    operator_check = false;
                    operator="/";
                    second_value = input_screen.getText().toString();
                    result = Integer.valueOf(first_value)/Integer.valueOf(second_value);
                    input_screen.setText("0");
                    for_screen="";
                    result_screen.setText(String.valueOf(result));
                }
                }catch (Exception e){

                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(operator_check==false){
                    first_value = input_screen.getText().toString();
                    operator="+";
                    input_screen.setText("0");
                    for_screen="";
                    operator_check=true;
                    if(result!=0){
                        second_value =first_value;
                        first_value = String.valueOf(result);
                        result=Integer.valueOf(first_value)+Integer.valueOf(second_value);
                        result_screen.setText(String.valueOf(result));
                        operator_check=false;
                    }
                }else{
                    operator_check = false;
                    operator="+";
                    second_value = input_screen.getText().toString();
                    result = Integer.valueOf(first_value)+Integer.valueOf(second_value);
                    input_screen.setText("0");
                    for_screen="";
                    result_screen.setText(String.valueOf(result));
                }
            }catch (Exception e){

                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(operator_check==false){
                    first_value = input_screen.getText().toString();
                    operator="-";
                    input_screen.setText("0");
                    for_screen="";
                    operator_check=true;
                    if(result!=0){
                        second_value =first_value;
                        first_value = String.valueOf(result);
                        result=Integer.valueOf(first_value)-Integer.valueOf(second_value);
                        result_screen.setText(String.valueOf(result));
                        operator_check=false;
                    }
                }else{
                    operator_check = false;
                    operator="-";
                    second_value = input_screen.getText().toString();
                    result = Integer.valueOf(first_value)-Integer.valueOf(second_value);
                    input_screen.setText("0");
                    for_screen="";
                    result_screen.setText(String.valueOf(result));
                }
            }catch (Exception e){

                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(operator_check==false){
                    first_value = input_screen.getText().toString();
                    operator="*";
                    input_screen.setText("0");
                    for_screen="";
                    operator_check=true;
                    if(result!=0){
                        second_value =first_value;
                        first_value = String.valueOf(result);
                        result=Integer.valueOf(first_value)*Integer.valueOf(second_value);
                        result_screen.setText(String.valueOf(result));
                        operator_check=false;
                    }
                }else{
                    operator_check = false;
                    operator="*";
                    second_value = input_screen.getText().toString();
                    result = Integer.valueOf(first_value)*Integer.valueOf(second_value);
                    input_screen.setText("0");
                    for_screen="";
                    result_screen.setText(String.valueOf(result));
                }
            }catch (Exception e){

                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{second_value = input_screen.getText().toString();
                    int first= Integer.parseInt(first_value);
                    int second=Integer.parseInt(second_value);
                    switch (operator){
                    case "%":
                        try{
                            result=first%second;
                            if(operator_check==false){
                                first_value = input_screen.getText().toString();
                                operator="%";
                                input_screen.setText("0");
                                for_screen="";
                                operator_check=true;
                                if(result!=0){
                                    second_value =first_value;
                                    first_value = String.valueOf(result);
                                    result=Integer.valueOf(first_value)%Integer.valueOf(second_value);
                                    result_screen.setText(String.valueOf(result));
                                    operator_check=false;
                                }
                            }else{
                                operator_check = false;
                                operator="%";
                                second_value = input_screen.getText().toString();
                                result = Integer.valueOf(first_value)%Integer.valueOf(second_value);
                                input_screen.setText("0");
                                for_screen="";
                                result_screen.setText(String.valueOf(result));
                            }
                        }catch (Exception e){
                            result_screen.setText(e.toString());
                        }
                        break;
                    case "/":
                        try{
                            result=first/second;
                            if(operator_check==false){
                                first_value = input_screen.getText().toString();
                                operator="/";
                                input_screen.setText("0");
                                for_screen="";
                                operator_check=true;
                                if(result!=0){
                                    second_value =first_value;
                                    first_value = String.valueOf(result);
                                    result=Integer.valueOf(first_value)/Integer.valueOf(second_value);
                                    result_screen.setText(String.valueOf(result));
                                    operator_check=false;
                                }
                            }else{
                                operator_check = false;
                                operator="/";
                                second_value = input_screen.getText().toString();
                                result = Integer.valueOf(first_value)/Integer.valueOf(second_value);
                                input_screen.setText("0");
                                for_screen="";
                                result_screen.setText(String.valueOf(result));
                            }
                        }catch (Exception e){
                            result_screen.setText(e.toString());
                        }
                        break;
                    case "+":
                        try{
                            result=first+second;
                            first_value="";
                            second_value="";
                            if(operator_check==false){
                                first_value = input_screen.getText().toString();
                                operator="+";
                                input_screen.setText("0");
                                for_screen="";
                                operator_check=true;
                                if(result!=0){
                                    second_value =first_value;
                                    first_value = String.valueOf(result);
                                    result=Integer.valueOf(first_value)+Integer.valueOf(second_value);
                                    result_screen.setText(String.valueOf(result));
                                    operator_check=false;
                                }
                            }else{
                                operator_check = false;
                                operator="+";
                                second_value = input_screen.getText().toString();
                                result = Integer.valueOf(first_value)+Integer.valueOf(second_value);
                                input_screen.setText("0");
                                for_screen="";
                                result_screen.setText(String.valueOf(result));
                            }
                        }catch (Exception e){
                            result_screen.setText(e.toString());
                        }
                        break;
                    case "-":
                        try{
                            result=first-second;
                            first_value="";
                            second_value="";
                            if(operator_check==false){
                                first_value = input_screen.getText().toString();
                                operator="-";
                                input_screen.setText("0");
                                for_screen="";
                                operator_check=true;
                                if(result!=0){
                                    second_value =first_value;
                                    first_value = String.valueOf(result);
                                    result=Integer.valueOf(first_value)-Integer.valueOf(second_value);
                                    result_screen.setText(String.valueOf(result));
                                    operator_check=false;
                                }
                            }else{
                                operator_check = false;
                                operator="-";
                                second_value = input_screen.getText().toString();
                                result = Integer.valueOf(first_value)-Integer.valueOf(second_value);
                                input_screen.setText("0");
                                for_screen="";
                                result_screen.setText(String.valueOf(result));
                            }
                        }catch (Exception e){
                            result_screen.setText(e.toString());
                        }
                        break;
                    case "*":
                        try{
                            result=first*second;
                            first_value="";
                            second_value="";
                        }catch (Exception e){
                            result_screen.setText(e.toString());
                        }
                        break;
                }
                result_screen.setText(String.valueOf(result));
            }catch (Exception e){

                }
            }
        });
    }
    public void screenInput(int num){
        for_screen += num;
        input_screen.setText(for_screen);
    }

}
