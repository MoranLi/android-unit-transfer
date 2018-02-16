/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;
public class Weight {
    public enum weight_type{kilogram,gram,milligram,ton,pound,ounce,carat};

    weight_type type;

    double value;

    public Weight(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "g":
                type = weight_type.gram;
                break;
            case "kg":
                type = weight_type.kilogram;
                break;
            case "mg":
                type = weight_type.milligram;
                break;
            case "t":
                type = weight_type.ton;
                break;
            case "pound":
                type = weight_type.pound;
                break;
            case "ounce":
                type = weight_type.ounce;
                break;
            case "carat":
                type = weight_type.carat;
                break;
        }
    }

    public double toGram(Weight input){
        switch (input.type){
            case gram:
                return input.value;
            case kilogram:
                return input.value*1000;
            case milligram:
                return input.value/1000;
            case ounce:
                return input.value*28.349523125;
            case pound:
                return input.value*453.59237;
            case ton:
                return input.value*1000000;
            case carat:
                return input.value*0.2;
        }
        return -1.0;
    }

    public double toResult(Weight input,String output_type){
        double result = toGram(input);
        switch (output_type){
            case "g":
                return result;
            case "kg":
                return result/1000;
            case "mg":
                return result*1000;
            case "t":
                return result/1000000;
            case "pound":
                return result/453.59237;
            case "ounce":
                return result/28.349523125;
            case "carat":
                return input.value/0.2;
        }
        return -1.0;
    }

    public static void main(String[] args) {


    }
}
