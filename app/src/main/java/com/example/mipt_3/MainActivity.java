package com.example.mipt_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView mainScreen;
    String operation = "0";
    boolean newOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainScreen = findViewById(R.id.txtViewMainWindow);
    }

    private void setWorkings(String Value){
        if(newOperation == false){
            if(operation.equals("0")){
                if (Value.equals("0")){}
                else{
                    operation = Value;
                    newOperation = true;
                }
            }
            else{
                newOperation = true;
                operation = operation + Value;
            }
        }
        else{
            operation = operation + Value;
        }
        mainScreen.setText(operation);
    }


    public void btnCalculate (View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(operation);
            newOperation = false;
        } catch (ScriptException e) {
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if(result != null)
            operation = String.valueOf(result);
        mainScreen.setText(String.valueOf(result.doubleValue()));
    }

    public void btn0Click (View view){
        setWorkings("0");
    }
    public void btn1Click (View view){
        setWorkings("1");
    }
    public void btn2Click (View view){
        setWorkings("2");
    }
    public void btn3Click (View view){
        setWorkings("3");
    }
    public void btn4Click (View view){
        setWorkings("4");
    }
    public void btn5Click (View view){
        setWorkings("5");
    }
    public void btn6Click (View view){
        setWorkings("6");
    }
    public void btn7Click (View view){
        setWorkings("7");
    }
    public void btn8Click (View view){
        setWorkings("8");
    }
    public void btn9Click (View view){
        setWorkings("9");
    }

    public void btnPlusClick (View view){
        setWorkings("+");
    }
    public void btnMinusClick (View view){
        setWorkings("-");
    }
    public void btnDeviClick (View view){
        setWorkings("/");
    }
    public void btnMultClick (View view){
        setWorkings("*");
    }
}