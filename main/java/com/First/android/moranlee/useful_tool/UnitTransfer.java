package com.First.android.moranlee.useful_tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.First.android.moranlee.useful_tool.Data.Area;
import com.First.android.moranlee.useful_tool.Data.DataStorage;
import com.First.android.moranlee.useful_tool.Data.ExchangeRate;
import com.First.android.moranlee.useful_tool.Data.Length;
import com.First.android.moranlee.useful_tool.Data.NumberFormat;
import com.First.android.moranlee.useful_tool.Data.Temperature;
import com.First.android.moranlee.useful_tool.Data.Time;
import com.First.android.moranlee.useful_tool.Data.Volume;
import com.First.android.moranlee.useful_tool.Data.Weight;

public class UnitTransfer extends AppCompatActivity {

    Spinner unit;

    Spinner unit1;

    Spinner unit2;

    EditText value1;

    TextView value2;

    Button transfer;

    Button goBack;

    ArrayAdapter unitAdapter;

    ArrayAdapter unit1Adapter;

    ArrayAdapter unit2Adapter;

    String onItemSelected;

    String AType;
    String BType;
    Double AValue;
    Double BValue = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unittransfer);
        unit = (Spinner)findViewById(R.id.units_select);
        unit1 = (Spinner)findViewById(R.id.unit1);
        unit2 = (Spinner)findViewById(R.id.unit2);
        value1 = (EditText)findViewById(R.id.unit1_value);
        value1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        value2 = (TextView)findViewById(R.id.unit2_value);
        transfer = (Button) findViewById(R.id.transfer);
        goBack = (Button) findViewById(R.id.unitGoBack);
        goBack.setOnClickListener(mainOnClick());
        onItemSelected = "Length";
        unitAdapter = ArrayAdapter.createFromResource(this,R.array.units,R.layout.support_simple_spinner_dropdown_item);
        unit1Adapter = ArrayAdapter.createFromResource(this,R.array.length,R.layout.support_simple_spinner_dropdown_item);
        unit2Adapter = ArrayAdapter.createFromResource(this,R.array.length,R.layout.support_simple_spinner_dropdown_item);
        unit.setAdapter(unitAdapter);
        unit.setVisibility(View.VISIBLE);
        unit.setSelection(0);
        unit.setOnItemSelectedListener(onUnitSelect());
        unit1.setAdapter(unit1Adapter);
        unit1.setVisibility(View.VISIBLE);
        unit1.setSelection(0);
        unit1.setOnItemSelectedListener(OnUnit1Select());
        unit2.setAdapter(unit2Adapter);
        unit2.setVisibility(View.VISIBLE);
        unit2.setSelection(0);
        unit2.setOnItemSelectedListener(OnUnit2Select());
        value1.setOnEditorActionListener(OnEditedValue());
        transfer.setOnClickListener(transferButton());
    }

    private AdapterView.OnItemSelectedListener onUnitSelect(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Context some = unitAdapter.getContext();
                switch (position){
                    case 0:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.length,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.length,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Length";
                        break;
                    case 1:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.temperature,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.temperature,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Temperature";
                        break;
                    case 2:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.volume,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.volume,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Volume";
                        break;
                    case 3:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.number,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.number,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "NumberFormat";
                        break;
                    case 4:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.data_storage,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.data_storage,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Data Storage";
                        break;
                    case 5:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.area,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.area,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Area";
                        break;
                    case 6:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.weight,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.weight,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Weight";
                        break;
                    case 7:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.time,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.time,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Time";
                        break;
                    case 8:
                        unit1Adapter = ArrayAdapter.createFromResource(some,R.array.exchange_rate,R.layout.support_simple_spinner_dropdown_item);
                        unit2Adapter = ArrayAdapter.createFromResource(some,R.array.exchange_rate,R.layout.support_simple_spinner_dropdown_item);
                        onItemSelected = "Exchange Rate";
                        break;
                }
                unit1.setAdapter(unit1Adapter);
                unit1.setVisibility(View.VISIBLE);
                unit1.setSelection(0);
                unit2.setAdapter(unit2Adapter);
                unit2.setVisibility(View.VISIBLE);
                unit2.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        };
    }

    public AdapterView.OnItemSelectedListener OnUnit1Select(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AType = unit1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }

    public AdapterView.OnItemSelectedListener OnUnit2Select(){
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                BType = unit2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }

    public TextView.OnEditorActionListener OnEditedValue(){
        return new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                AValue = Double.parseDouble(value1.getText().toString());
                return true;
            }
        };
    }

    public View.OnClickListener transferButton(){
        AValue = Double.parseDouble(value1.getText().toString());
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (onItemSelected){
                    case "Length":
                        Length some0 = new Length(AType,AValue);
                        Double result0 = some0.toResult(some0,BType);
                        value2.setText(result0.toString());
                        break;
                    case "Temperature":
                        Temperature some1 = new Temperature(AType,AValue);
                        Double result1 = some1.toResult(some1,BType);
                        value2.setText(result1.toString());
                        break;
                    case "Volume":
                        Volume some2 = new Volume(AType,AValue);
                        Double result2 = some2.toResult(some2,BType);
                        value2.setText(result2.toString());
                        break;
                    case "Data Storage":
                        DataStorage some3 = new DataStorage(AType,AValue);
                        Double result3 = some3.toResult(some3,BType);
                        value2.setText(result3.toString());
                        break;
                    case "Time":
                        Time some4 = new Time(AType,AValue);
                        Double result4 = some4.toResult(some4,BType);
                        value2.setText(result4.toString());
                        break;
                    case "Area":
                        Area some5 = new Area(AType,AValue);
                        Double result5 = some5.toResult(some5,BType);
                        value2.setText(result5.toString());
                        break;
                    case "Weight":
                        Weight some6 = new Weight(AType,AValue);
                        Double result6 = some6.toResult(some6,BType);
                        value2.setText(result6.toString());
                        break;
                    case "NumberFormat":
                        NumberFormat some7 = new NumberFormat(AType,AValue);
                        Double result7 = some7.toResult(some7,BType);
                        value2.setText(result7.toString());
                        break;
                    case "Exchange Rate":
                        exchangeThread exchange = new exchangeThread();
                        exchange.start();
                        value2.setText(Double.toString(exchange.getExchange()));
                }
            }
        };

    }

    public Activity getItSelf(){
        return this;
    }

    public View.OnClickListener mainOnClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_intent = new Intent(getItSelf(),MainActivity.class);
                startActivity(main_intent);
            }
        };
    }

    public class exchangeThread extends Thread{
        @Override
        public void run() {
            ExchangeRate some8 = new ExchangeRate();
            Double result8 = some8.doexchange(AType,BType,AValue);
            //value2.setText(result8.toString());
            BValue = result8;
        }
        public double getExchange(){
            return BValue;
        }
    }


}
