/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;
public class NumberFormat {

    public enum number_type{binary,decimal};

    number_type type;

    double value;

    public NumberFormat(String type_in, double value_in){
        value = value_in;
        switch (type_in){
            case "binary":
                type= number_type.binary;
                break;
            case "decimal":
                type = number_type.decimal;
                break;
        }
    }

    public double toResult(NumberFormat input, String output_type){
        if(input.type==number_type.binary && output_type.equals("decimal")){
            String [] some = before_after_dot(String.valueOf(input.value));
            return binary_to_decimal(some[0],some[1]);
        }
        else if(input.type==number_type.decimal && output_type.equals("binary")){
            String [] some = before_after_dot(String.valueOf(input.value));
            return decimal_to_binary(some[0],some[1]);
        }
        else{
            return input.value;
        }
    }

    public String[] before_after_dot(String input){
        String [] seperate = input.split("\\.");
        return seperate;
    }

    public double binary_to_decimal(String before_dot, String after_dot){
        double before_zero = 0.0;
        double after_zero = 0.0;
        int count = 0;
        for(int i=before_dot.length()-1;i>=0;i--){
            char num = before_dot.charAt(i);
            int numT = Character.getNumericValue(num);
            if(numT!=0) {
                before_zero += Math.pow(2, count);
            }
            count++;
        }
        count = 1;
        for(int i=0;i<after_dot.length();i++){
            char num = after_dot.charAt(i);
            int numT = Character.getNumericValue(num);
            if(numT!=0) {
                after_zero += Math.pow(2, 0-count);
            }
            count++;
        }
        return before_zero+after_zero;
    }

    public double decimal_to_binary(String before_dot,String after_dot){
        double before= Double.parseDouble(Integer.toBinaryString (Integer.parseInt(before_dot)));
        double after = Double.parseDouble(after_dot);
        while(true){
            after= after/10;
            if(after<1){
                break;
            }
        }
        int count = 1;
        String temp = "0.";
        for(int i=0;i<15;i++){
            if (after>=Math.pow(2,0-count)){
                after= after - Math.pow(2,0-count);
                temp+="1";
            }
            else{
                temp +="0";
            }
            count++;
        }
        after = Double.parseDouble(temp);
        return before+after;
    }

    public static void main(String[] args) {
       NumberFormat test1 = new NumberFormat("binary",101);
       String [] some = test1.before_after_dot("3.5");
        System.out.println(some[0]);
        System.out.println(some[1]);
        //System.out.println(test1.binary_to_decimal(some[0],some[1]));
        System.out.println(test1.decimal_to_binary(some[0],some[1]));


    }
}
