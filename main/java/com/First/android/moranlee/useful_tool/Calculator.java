package com.First.android.moranlee.useful_tool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.First.android.moranlee.useful_tool.Data.ExpressionTree;

public class Calculator extends AppCompatActivity {

    TextView input;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        input = (TextView)findViewById(R.id.calculator_screen);
        result = (TextView)findViewById(R.id.result_screen);
    }

    public void addExpression(View v){
        Button b = (Button) v;
        String update_expression = (String) input.getText() + b.getText();
        input.setText(update_expression);
    }

    public void DoExpression(View v){
        ExpressionTree tree = new ExpressionTree();
        String inputs = input.getText().toString();
        result.setText(Double.toString(tree.doExpression(input.getText().toString())));

    }

    public Activity getItSelf(){
        return this;
    }

    public void GoBack(View v){
        Intent main_intent = new Intent(getItSelf(),MainActivity.class);
        startActivity(main_intent);
    }

    public void clearInput(View v){
        input.setText("");
    }

}
