package com.First.android.moranlee.useful_tool.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yul04 on 2017/9/10.
 */
public class getFood {
    LinkedList<String> lunch;
    LinkedList<String> dinner;
    public getFood(){

    }
    public void getFoodList(){
        lunch = new LinkedList<>();
        dinner = new LinkedList<>();
        try {
            URL url = new URL("https://www.usask.ca/culinaryservices/marquis-menu.php");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            for(int i=0;i<1125;i++){
                if(i<784 || (i>939 && i<946)){
                    reader.readLine();
                }
                if(i>784 && i<939){
                    lunch.add(reader.readLine());
                }
                if(i>946){
                    dinner.add(reader.readLine());
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeNotNeedLine(){
        for(int i=0;i<lunch.size();i++){
            if (lunch.get(i).length()<20){
                lunch.remove(i);
                i--;
            }
        }
        for(int i=0;i<dinner.size();i++){
            if (dinner.get(i).length()<20){
                dinner.remove(i);
                i--;
            }
        }
    }
    public void getSpecificName(){
        Pattern pattern = Pattern.compile("(<td>(.*?)<\\/td>)");
        Pattern pattern1 = Pattern.compile("(<p>(.*?)<\\/p>)");
        LinkedList<String> newLunch = new LinkedList<>();
        for(int i=0;i<lunch.size();i++){
            Matcher matcher = pattern.matcher(lunch.get(i));
            Matcher matcher1 = pattern1.matcher(lunch.get(i));
            if(matcher.matches()){
                newLunch .add(lunch.get(i).substring(matcher.start()+4,matcher.end()-5));
            }
            if (matcher1.matches()){
                newLunch .add(lunch.get(i).substring(matcher1.start()+3,matcher1.end()-4));
            }
        }
        LinkedList<String> newSupper = new LinkedList<>();
        for(int i=0;i<dinner.size();i++){
            Matcher matcher = pattern.matcher(dinner.get(i));
            Matcher matcher1 = pattern1.matcher(dinner.get(i));
            if(matcher.matches()){
                newSupper.add(dinner.get(i).substring(matcher.start()+4,matcher.end()-5));
            }
            if (matcher1.matches()){
                newSupper.add(dinner.get(i).substring(matcher1.start()+3,matcher1.end()-4));
            }
        }
        lunch = newLunch;
        dinner = newSupper;
    }
    public void removeUnexceptedLine(){
        lunch.remove(2);
        lunch.remove(18);
        lunch.remove(20);
        dinner.remove(0);
        dinner.remove(3);
        dinner.remove(6);
        dinner.remove(10);
        dinner.remove(10);
        dinner.remove(10);
        dinner.remove(10);
        dinner.remove(10);
        dinner.remove(10);
        dinner.remove(10);
        dinner.remove(10);
        String temp = dinner.get(14).substring(0,14);
        dinner.add(15,temp);
        dinner.remove(14);
        dinner.add(15,lunch.get(lunch.size()-3));
    }

    public String [] toResultString(){
        doAll();
        String [] result = new String[2];
        String r1 = "Lunch \n";
        String r2 = "Supper \n";
        for(int i=0;i<lunch.size();i++){
            r1=r1+lunch.get(i)+"\n";
        }
        for(int i=0;i<dinner.size();i++){
            r2=r2+dinner.get(i)+"\n";
        }
        result[0] = r1;
        result[1] = r2;
        return result;
    }

    public void doAll(){
        getFoodList();
        removeNotNeedLine();
        getSpecificName();
        removeUnexceptedLine();
    }

    public static void main(String[] args) {
        /*
        LinkedList<String> lunch = new LinkedList<>();
        LinkedList<String> dinner = new LinkedList<>();
        try {
            URL url = new URL("https://www.usask.ca/culinaryservices/marquis-menu.php");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            for(int i=0;i<1125;i++){
                if(i<784 || (i>939 && i<946)){
                    reader.readLine();
                }
                if(i>784 && i<939){
                    lunch.add(reader.readLine());
                }
                if(i>946){
                    dinner.add(reader.readLine());
                }
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        for(int i=0;i<lunch.size();i++){
            if (lunch.get(i).length()<20){
                lunch.remove(i);
                i--;
            }
        }
        for(int i=0;i<dinner.size();i++){
            if (dinner.get(i).length()<20){
                dinner.remove(i);
                i--;
            }
        }
        Pattern pattern = Pattern.compile("(<td>(.*?)<\\/td>)");
        Pattern pattern1 = Pattern.compile("(<p>(.*?)<\\/p>)");
        LinkedList<String> newLunch = new LinkedList<>();
        for(int i=0;i<lunch.size();i++){
            Matcher matcher = pattern.matcher(lunch.get(i));
            Matcher matcher1 = pattern1.matcher(lunch.get(i));
            if(matcher.matches()){
                newLunch .add(lunch.get(i).substring(matcher.start()+4,matcher.end()-5));
            }
            if (matcher1.matches()){
                newLunch .add(lunch.get(i).substring(matcher1.start()+3,matcher1.end()-4));
            }
        }
        LinkedList<String> newSupper = new LinkedList<>();
        for(int i=0;i<dinner.size();i++){
            Matcher matcher = pattern.matcher(dinner.get(i));
            Matcher matcher1 = pattern1.matcher(dinner.get(i));
            if(matcher.matches()){
                newSupper.add(dinner.get(i).substring(matcher.start()+4,matcher.end()-5));
            }
            if (matcher1.matches()){
                newSupper.add(dinner.get(i).substring(matcher1.start()+3,matcher1.end()-4));
            }
        }
        newLunch.remove(2);
        newLunch.remove(18);
        newLunch.remove(20);
        newSupper.remove(0);
        newSupper.remove(3);
        newSupper.remove(6);
        newSupper.remove(10);
        newSupper.remove(10);
        newSupper.remove(10);
        newSupper.remove(10);
        newSupper.remove(10);
        newSupper.remove(10);
        newSupper.remove(10);
        newSupper.remove(10);
        String temp = newSupper.get(14).substring(0,14);
        newSupper.add(15,temp);
        newSupper.remove(14);
        newSupper.add(15,newLunch.get(newLunch.size()-3));
        System.out.println("Lunch");
        for(int i=0;i<newLunch .size();i++){
            System.out.println(newLunch .get(i)+"\t"+newLunch .get(i).length());
        }
        System.out.println("Supper");
        for(int i=0;i<newSupper .size();i++){
            System.out.println(newSupper .get(i)+"\t"+newSupper .get(i).length());
        }
        */
        getFood some = new getFood();
        some.doAll();
        for(int i=0;i<some.lunch.size();i++){
            System.out.println(some.lunch.get(i));
        }
        for (int i=0;i<some.dinner.size();i++){
            System.out.println(some.dinner.get(i));
        }
    }
}
