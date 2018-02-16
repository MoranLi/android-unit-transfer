/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;

public class Length {

    public enum length_type{centimeter,meter,kilometer,inch,foot,mile,decimeter,nanometer,yard,light_year,millimeter};

    length_type type;

    double value;

    public Length(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "cm":
                type = length_type.centimeter;
                break;
            case "m":
                type = length_type.meter;
                break;
            case "km":
                type = length_type.kilometer;
                break;
            case "inch":
                type = length_type.inch;
                break;
            case "foot":
                type = length_type.foot;
                break;
            case "mile":
                type = length_type.mile;
                break;
            case "dm":
                type = length_type.decimeter;
                break;
            case "yard":
                type = length_type.yard;
                break;
            case "light year":
                type = length_type.light_year;
                break;
            case "nm":
                type = length_type.nanometer;
                break;
            case "mm":
                type = length_type.millimeter;
                break;
        }
    }

    public double toMeter(Length input){
        switch (input.type){
            case centimeter:
                return input.value*0.01;
            case foot:
                return input.value*0.3048;
            case inch:
                return input.value*0.0254;
            case kilometer:
                return input.value*1000;
            case meter:
                return input.value;
            case mile:
                return input.value*1609.344;
            case decimeter:
                return input.value*0.1;
            case yard:
                return input.value*0.9144;
            case light_year:
                return input.value*9460730472580044.0;
            case nanometer:
                return input.value*0.000000001;
            case millimeter:
                return input.value*0.001;
        }
        return -1.0;
    }

    public double toResult(Length input,String output_type){
        double result = toMeter(input);
        switch (output_type){
            case "cm":
                return result*100;
            case "m":
                return result;
            case "inch":
                return result*39.370079;
            case "km":
                return result*0.001;
            case "foot":
                return result*3.2808399;
            case "mile":
                return result*0.00062137119;
            case "dm":
                return result*10;
            case "yard":
                return result/0.9144;
            case "light year":
                return result/9460730472580044.0;
            case "nm":
                return result*1000000000;
            case "mm":
                return result*1000;
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Length length1 = new Length("cm",1.0);
        Length length2 = new Length("m",1);
        System.out.println(length1.toResult(length2,"m"));
        System.out.println(length1.toResult(length2,"cm"));
        System.out.println(length1.toResult(length2,"km"));
        System.out.println(length1.toResult(length2,"inch"));
        System.out.println(length1.toResult(length2,"foot"));

    }

}
