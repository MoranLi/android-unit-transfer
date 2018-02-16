/**
 * Created by yul04 on 2017/8/18.
 */
package com.First.android.moranlee.useful_tool.Data;
public class DataStorage {
    public enum data_type{KB,MB,GB,TB,BYTE,BIT,WORD,PB};

    data_type type;

    double value;

    public DataStorage(String type_in,double value_in){
        value = value_in;
        switch (type_in){
            case "KB":
                type = data_type.KB;
                break;
            case "BIT":
                type = data_type.BIT;
                break;
            case "BYTE":
                type = data_type.BYTE;
                break;
            case "MB":
                type = data_type.MB;
                break;
            case "GB":
                type = data_type.GB;
                break;
            case "TB":
                type = data_type.TB;
                break;
            case "WORD":
                type = data_type.WORD;
                break;
            case "PB":
                type = data_type.PB;
                break;
        }
    }

    public double to_MB(DataStorage input){
        switch (input.type){
            case BIT:
                return input.value*1.25E-7;
            case GB:
                return input.value*1000;
            case KB:
                return input.value*0.01;
            case BYTE:
                return input.value*0.000001;
            case MB:
                return input.value;
            case TB:
                return input.value*1000000;
            case WORD:
                return input.value*0.000002;
            case PB:
                return input.value*1000000000;
        }
        return -1.0;
    }

    public double toResult(DataStorage input,String output_type){
        double result = to_MB(input);
        switch (output_type){
            case "KB":
                return result/0.01;
            case "BIT":
                return result/1.25E-7;
            case "BYTE":
                return result/0.000001;
            case "MB":
                return result;
            case "GB":
                return result/1000;
            case "TB":
                return result/1000000;
            case "WORD":
                return result/0.000002;
            case "PB":
                return result/1000000000;
        }
        return -1.0;
    }

    public static void main(String[] args) {
        DataStorage test1 = new DataStorage("MB",1);
        System.out.println(test1.toResult(test1,"MB"));
        System.out.println(test1.toResult(test1,"KB"));
        System.out.println(test1.toResult(test1,"GB"));
        System.out.println(test1.toResult(test1,"TB"));
        System.out.println(test1.toResult(test1,"BYTE"));
        System.out.println(test1.toResult(test1,"BIT"));


    }
}
