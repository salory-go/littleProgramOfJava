package pairwork;

import java.util.ArrayList;

public class repeatTest {
    public repeatTest(){}
    public  boolean Test(String operationA,ArrayList<String> operations){
        for (String operation : operations) {
            //如果两者重复就返回true
            if (repeatTwoOperation(operationA, operation)) {
                return true;
            }
        }
        return false;
    }
    public String repeat(String operationA,ArrayList<String> operations){
        for (String operation : operations) {
            //如果两者重复就返回true
            if (repeatTwoOperation(operationA, operation)) {
                return operation;
            }
        }
        return "";
    }
    public static boolean repeatTwoOperation(String A,String B){

        //先判断答案一不一样，再判断操作数一不一样，再判断运算符一不一样
        //将答案、操作数、运算符分割
        String[] contentA = A.split(" ");
        String[] contentB = B.split(" ");
        //得到长度
        int lengthA = contentA.length;
        int lengthB = contentB.length;
        //得到答案
        String answerA = contentA[contentA.length-1];
        String answerB = contentB[contentB.length-1];
        //答案不一样则不重复
        if(!answerA.equals(answerB)){
            return false;
        }
        else {
            //得到操作数
            ArrayList<String> operationNumbersA = new ArrayList<>();
            ArrayList<String> operationNumbersB = new ArrayList<>();
            for (String s : contentA) {
                if(Character.isDigit(s.charAt(0))){
                    operationNumbersA.add(s);
                }
            }
            for (String s : contentB) {
                if(Character.isDigit(s.charAt(0))){
                    operationNumbersB.add(s);
                }
            }
            //比较操作数
            boolean flag = true;
            for(String i:operationNumbersA){
                if(!operationNumbersB.contains(i)){
                    //如果有操作数不同
                    flag =false;
                    break;
                }
            }
            //操作数也相同时，flag为true
            if(flag){
                //得到操作符
                ArrayList<String > operatorA = new ArrayList<>();
                ArrayList<String > operatorB = new ArrayList<>();
                for (String s : contentA) {
                    //把数字和括号剔除
                    if(!Character.isDigit(s.charAt(0))&&s.charAt(0)!='('&&s.charAt(0)!=')'){
                        operatorA.add(s);
                    }
                }
                for (String s : contentB) {
                    if(!Character.isDigit(s.charAt(0))&&s.charAt(0)!='('&&s.charAt(0)!=')'){
                        operatorB.add(s);
                    }
                }
                for(String i:operatorA){
                    if(!operatorB.contains(i)){
                        return false;
                    }
                }
                return true;
            }
            else return false;
        }
    }

}
