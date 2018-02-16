/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;
public class Area {
    public enum area_type{square_meter,square_centimeter,square_kilometer,square_inch,square_foot,acre,square_mile,square_yard,square_decimeter,square_millimeter};

    area_type type;

    double value;

    public Area(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "m^2":
                type = area_type.square_meter;
                break;
            case "cm^2":
                type = area_type.square_centimeter;
                break;
            case "km^2":
                type = area_type.square_kilometer;
                break;
            case "inch^2":
                type = area_type.square_inch;
                break;
            case "foot^2":
                type = area_type.square_foot;
                break;
            case "acre":
                type = area_type.acre;
                break;
            case "dm^2":
                type = area_type.square_decimeter;
                break;
            case "mile^2":
                type = area_type.square_mile;
                break;
            case "mm^2":
                type = area_type.square_millimeter;
                break;
            case "yard^2":
                type = area_type.square_yard;
                break;
        }
    }

    public double to_square_meter(Area input){
        switch (input.type){
            case acre:
                return input.value*4046.85642;
            case square_centimeter:
                return input.value*0.0001;
            case square_kilometer:
                return input.value*1000000;
            case square_foot:
                return input.value*0.09290304;
            case square_inch:
                return input.value*0.00064516;
            case square_meter:
                return input.value;
            case square_yard:
                return input.value*0.83612736;
            case square_decimeter:
                return input.value*0.01;
            case square_mile:
                return input.value*2589988.1103;
            case square_millimeter:
                return input.value*0.000001;
        }
        return -1.0;
    }

    public double toResult(Area input,String output_type){
        double result = to_square_meter(input);
        switch (output_type){
            case "m^2":
                return result;
            case "cm^2":
                return result*10000;
            case "inch^2":
                return result*1550.0031;
            case "km^2":
                return result*0.000001;
            case "foot^2":
                return result*10.763910417;
            case "acre":
                return result*0.0002471054;
            case "dm^2":
                return result/0.01;
            case "mm^2":
                return result/0.000001;
            case "yard^2":
                return result/0.83612736;
            case "mile^2":
                return result/2589988.1103;
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Area area1 = new Area("m^2",1);
        Area area2 = new Area("km^2",4);
        System.out.println(area2.toResult(area1,"m^2"));
        System.out.println(area2.toResult(area1,"cm^2"));
        System.out.println(area2.toResult(area1,"km^2"));
        System.out.println(area2.toResult(area1,"inch^2"));
        System.out.println(area2.toResult(area1,"foot^2"));
        System.out.println(area2.toResult(area1,"acre"));
    }
}
