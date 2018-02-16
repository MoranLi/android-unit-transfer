package com.First.android.moranlee.useful_tool;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button unit;

    Button calculate;

    Button marquis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit=(Button)findViewById(R.id.unit);
        calculate=(Button)findViewById(R.id.calculate);
        marquis = (Button)findViewById(R.id.marquis);
        unit.setOnClickListener(unitOnClick());
        calculate.setOnClickListener(calculateOnClick());
        marquis.setOnClickListener(marquisOnClick());
    }

    public Activity getItSelf(){
        return this;
    }

    public View.OnClickListener unitOnClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unit_intent = new Intent(getItSelf(),UnitTransfer.class);
                startActivity(unit_intent);
            }
        };
    }

    public View.OnClickListener calculateOnClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculate_intent = new Intent(getItSelf(),Calculator.class);
                startActivity(calculate_intent);
            }
        };
    }
    public View.OnClickListener marquisOnClick(){
        return  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marquis_intent = new Intent(getItSelf(),getMarquisMenu.class);
                startActivity(marquis_intent);
            }
        };
    }

}
