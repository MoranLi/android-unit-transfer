package com.First.android.moranlee.useful_tool.Data;

import java.util.LinkedList;

/**
 * Created by yul04 on 2017/8/30.
 */
public class ExpressionTree {
    Node root;
    public class Node{
        String item;
        Node left;
        Node right;
        Node parent;
        public Node(){
            item = null;
            left = null;
            right = null;
            parent = null;
        }
    }
    public ExpressionTree(){
        root = new Node();
    }
    public void toExpressionTree(LinkedList<String> s){
        Node cursor = root;
        for(int i = 0;i<s.size();i++){
            if(isNumber(s.get(i))){
                if(cursor.left == null){
                    cursor.left = new Node();
                    cursor.left.parent = cursor;
                    cursor.left.item = s.get(i);
                }
                else {
                    cursor.right = new Node();
                    cursor.right.parent = cursor;
                    cursor.right.item = s.get(i);
                }
            }
            else{
                if(cursor.item == null){
                    cursor.item = s.get(i);
                }
                else{
                    if(((s.get(i).equals("*"))||(s.get(i).equals("/")))){
                        Node newNode = new Node();
                        newNode.item = s.get(i);
                        newNode.left = new Node();
                        newNode.left.item = cursor.right.item;
                        cursor.right = newNode;
                        newNode.parent = cursor;
                        cursor.parent = cursor;
                        cursor = newNode;
                    }
                    else {
                        if((s.get(i).equals("-") || s.get(i).equals("+")) && (cursor.item.equals("*") || cursor.item.equals("/"))){
                            cursor = cursor.parent;
                        }
                        Node newRoot = new Node();
                        newRoot.item = s.get(i);
                        newRoot.left = cursor;
                        root.parent = newRoot;
                        root = newRoot;
                        cursor = newRoot;
                    }
                }
            }
        }
    }
    public Double evaluate(Node exp){
        if(exp.left == null && exp.right == null){
            return Double.parseDouble(exp.item);
        }
        else{
            double result = 0.0;
            double left = evaluate(exp.left);
            double right = evaluate(exp.right);
            switch (exp.item){
                case "+":
                    result = left+right;
                    break;
                case "-":
                    result = left-right;
                    break;
                case "*":
                    result = left*right;
                    break;
                case "/":
                    result = left/right;
                    break;
            }
            return result;
        }
    }



    public boolean isNumber(String s){
        int some = (int)s.charAt(0);
        if(s.charAt(0)!='-') {
            if (((int) s.charAt(0)) >= 58 || ((int) s.charAt(0)) <= 47) {
                return false;
            }
        }
        else{
            if(s.length()>1) {
                if (((int) s.charAt(1)) >= 58 || ((int) s.charAt(1)) <= 47) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
    public LinkedList<String> StringToList(String s){
        LinkedList<String> result = new LinkedList<>();
        String NumTemp = "";
        for (int i =0;i<s.length();i++){
            if(isNumber(Character.toString(s.charAt(i)))||s.charAt(i) == '.'){
                if(NumTemp == "" && s.charAt(i) == '.'){
                    NumTemp+="0.";
                }
                else if(NumTemp == "" && isNumber(Character.toString(s.charAt(i)))){
                    NumTemp+=s.charAt(i);
                }
                else if(!(NumTemp.charAt(NumTemp.length()-1)=='.'&& s.charAt(i) == '.')) {
                    NumTemp+=s.charAt(i);
                }
            }
            else{
                if(NumTemp == "" && s.charAt(i) == '+'){

                }
                else if (NumTemp == "" && s.charAt(i) == '-'){
                    NumTemp+="-";
                }
                else if(result.size()!=0) {
                    if (!isNumber(result.getLast())) {
                        if(NumTemp.equals("")) {
                            if (s.charAt(i) == '-') {
                                NumTemp += "-";
                            }
                        }
                        else{
                            result.add(NumTemp);
                            result.add(Character.toString(s.charAt(i)));
                            NumTemp = "";
                        }
                    }
                }
                else {
                    result.add(NumTemp);
                    result.add(Character.toString(s.charAt(i)));
                    NumTemp = "";
                }
            }
        }
        result.add(NumTemp);
        return result;
    }

    public Double doExpression(String s){
        toExpressionTree(StringToList(s));
        return evaluate(root);
    }



    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree();
        LinkedList<String> some = tree.StringToList("11+-2.5-33.33*-45-222");
        System.out.println(tree.isNumber("-"));

        for(int i=0;i<some.size();i++){
           System.out.println(some.get(i));
        }

        tree.toExpressionTree(some);

        System.out.println(tree.evaluate(tree.root));





    }

}
