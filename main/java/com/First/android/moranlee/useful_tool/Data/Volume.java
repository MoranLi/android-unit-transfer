/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;
public class Volume {
    public enum volume_type{cube_meter,cube_centimeter,cube_kilometer,cube_inch,cube_foot,liter,milliliter,gallon,quart,pint,cup,tablespoon,teaspoon};

    volume_type type;

    double value;

    public Volume(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "m^3":
                type = volume_type.cube_meter;
                break;
            case "cm^3":
                type = volume_type.cube_centimeter;
                break;
            case "km^3":
                type = volume_type.cube_kilometer;
                break;
            case "inch^3":
                type = volume_type.cube_inch;
                break;
            case "foot^3":
                type = volume_type.cube_foot;
                break;
            case "liter":
                type = volume_type.liter;
                break;
            case "milliliter":
                type = volume_type.milliliter;
                break;
            case "gallon":
                type = volume_type.gallon;
                break;
            case "quart":
                type = volume_type.quart;
                break;
            case "pint":
                type = volume_type.pint;
                break;
            case "cup":
                type = volume_type.cup;
                break;
            case "tablespoon":
                type = volume_type.tablespoon;
                break;
            case "teaspoon":
                type = volume_type.teaspoon;
                break;
        }
    }

    public double to_cube_meter(Volume input){
        switch (input.type){
            case cube_centimeter:
                return input.value/1000000;
            case cube_foot:
                return input.value/35.314666721;
            case cube_inch:
                return input.value/61023.744095;
            case cube_kilometer:
                return input.value*Math.pow(10,9);
            case cube_meter:
                return input.value;
            case liter:
                return input.value/1000;
            case milliliter:
                return input.value*0.000001;
            case gallon:
                return input.value* 0.0037854118;
            case quart:
                return input.value*0.0009463529;
            case pint:
                return input.value*0.0004731765;
            case cup:
                return input.value*0.0002365882;
            case tablespoon:
                return input.value*0.0000147868;
            case teaspoon:
                return input.value*0.0000049289;
        }
        return -1.0;
    }

    public double toResult(Volume input,String output_type){
        double result = to_cube_meter(input);
        switch (output_type){
            case "m^3":
                return result;
            case "cm^3":
                return result*1000000;
            case "inch^3":
                return result*61023.744095;
            case "km^3":
                return result*Math.pow(10,-9);
            case "foot^3":
                return result*35.314666721;
            case "liter":
                return result*1000;
            case "milliliter":
                return result*1000000;
            case "gallon":
                return result*264.17205236;
            case "quart":
                return result*1056.6882094;
            case "pint":
                return result*2113.3764189;
            case "cup":
                return result*4226.7528377;
            case "tablespoon":
                return result*67628.045404;
            case "teaspoon":
                return result*202884.13621;
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Volume volume1 = new Volume("m^3",1);
        System.out.println(volume1.toResult(volume1,"m^3"));
        System.out.println(volume1.toResult(volume1,"cm^3"));
        System.out.println(volume1.toResult(volume1,"km^3"));
        System.out.println(volume1.toResult(volume1,"inch^3"));
        System.out.println(volume1.toResult(volume1,"foot^3"));
        System.out.println(volume1.toResult(volume1,"liter"));
    }
}
