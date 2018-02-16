/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;
public class Temperature {
    public enum temperature_type{C,K,F};

    temperature_type type;

    double value;

    public Temperature(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "C":
                type = temperature_type.C;
                break;
            case "K":
                type = temperature_type.K;
                break;
            case "F":
                type = temperature_type.F;
                break;
        }
    }

    public double to_C(Temperature input){
        switch (input.type){
            case C:
                return input.value;
            case F:
                return (input.value-32)*5/9;
            case K:
                return input.value-273.15;
        }
        return -1.0;
    }

    public double toResult(Temperature input,String output_type){
        double result = to_C(input);
        switch (output_type){
            case "C":
                return result;
            case "K":
                return result+273.15;
            case "F":
                return result*9/5+32;
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Temperature test1 = new Temperature("C",1);
        System.out.println(test1.toResult(test1,"C"));
        System.out.println(test1.toResult(test1,"K"));
        System.out.println(test1.toResult(test1,"F"));



    }
}
