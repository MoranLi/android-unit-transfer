package com.First.android.moranlee.useful_tool.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yul04 on 2017/8/26.
 */
public class ExchangeRate {

    public double doexchange(String from, String to,double value) {
        String [] result = new String[12];
        String fromValue = "";
        String toValue = "";
        try {
            URL url = new URL("http://apilayer.net/api/live?access_key=4c1f943cd7f06844824b0baa3e56d157&currencies="+from+","+to+"&format=1");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            for(int i=0;i<12;i++){
                result[i] = reader.readLine();
            }
            System.out.println(result[7]);
            System.out.println(result[8]);
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        Pattern p = Pattern.compile(":.*");
        Matcher fromm = p.matcher(result[7]);
        Matcher tom   = p.matcher(result[8]);
        if(fromm.find()&& tom.find()){
            String fromResult = fromm.group(0);
            fromValue = fromResult.substring(1,fromResult.length()-1);
            System.out.println(fromValue);
            String toResult = tom.group(0);
            toValue = toResult.substring(1);
            System.out.println(toValue);
        }
        double USDFrom = Double.parseDouble(fromValue);
        double USDTO   = Double.parseDouble(toValue);
        return value/USDFrom*USDTO;
    }

    public static void main(String[] args) {
        ExchangeRate doex = new ExchangeRate();
        System.out.println(doex.doexchange("CNY","CAD",1));
    }
}
