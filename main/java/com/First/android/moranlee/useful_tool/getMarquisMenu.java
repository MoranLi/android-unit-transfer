package com.First.android.moranlee.useful_tool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.First.android.moranlee.useful_tool.Data.getFood;


public class getMarquisMenu extends AppCompatActivity {

    String [] result = {"",""};
    TextView marquisLunch;
    TextView marquisDinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_marquis_menu);
        marquisLunch =(TextView) findViewById(R.id.marquisLunch);
        marquisDinner = (TextView) findViewById(R.id.marquisDinner);
        dosonthingelse();
    }

    public void dosonthingelse(){
        marquisThread marquis = new marquisThread();
        marquis.start();
        try{
            marquis.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        String [] some = marquis.getMenu();
        marquisLunch.setText(some[0]);
        marquisDinner.setText(some[1]);
    }

    public class marquisThread extends Thread{
        @Override
        public void run() {
            getFood some = new getFood();
            result = some.toResultString();
        }
        public String [] getMenu(){
            return result;
        }
    }

    public Activity getItSelf(){
        return this;
    }

    public void GoBack(View v){
        Intent main_intent = new Intent(getItSelf(),MainActivity.class);
        startActivity(main_intent);
    }


}
