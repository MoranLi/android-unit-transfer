

/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;

public class Time {
    public enum time_type{second,minute,hour,day,month,year,millisecond,week};

    time_type type;

    double value;

    public Time(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "millisecond":
                type = time_type.millisecond;
                break;
            case "second":
                type = time_type.second;
                break;
            case "minute":
                type = time_type.minute;
                break;
            case "hour":
                type = time_type.hour;
                break;
            case "day":
                type = time_type.day;
                break;
            case "week":
                type = time_type.week;
                break;
            case "month":
                type = time_type.month;
                break;
            case "year":
                type = time_type.year;
                break;
        }
    }

    public double to_day(Time input){
        switch (input.type){
            case day:
                return input.value;
            case hour:
                return input.value/24;
            case minute:
                return input.value/1440;
            case month:
                return input.value*30;
            case second:
                return input.value/86400;
            case year:
                return input.value*365;
            case millisecond:
                return input.value/86400000;
            case week:
                return input.value*7;
        }
        return -1.0;
    }

    public double toResult(Time input,String output_type){
        double result = to_day(input);
        switch (output_type){
            case "second":
                return result*86400;
            case "minute":
                return  result*1440;
            case "hour":
                return result*24;
            case "day":
                return result;
            case "month":
                return result/30;
            case "year":
                return result/365;
            case "week":
                return result/7;
            case "millisecond":
                return result*86400000;
        }
        return -1.0;
    }

    public static void main(String[] args) {


    }
}
