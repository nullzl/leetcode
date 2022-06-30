package com.nullzl.util;



import java.util.Random;

public class Util {

    public static String generateRandomArray(int len,int s,int e){
        Random r = new Random();
        StringBuffer str = new StringBuffer();
        str.append("[");
        str.append((r.nextInt(e - s) + s));
        for(int i = 1 ; i < len ; i++) {
            str.append(",");
            str.append((r.nextInt(e - s) + s));
        }
        str.append("]");
        return str.toString();
    }

    public  static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(20);
        System.out.print("[" + Util.generateRandomArray(len , 0, 2));
        for(int i = 1  ;i < len ; i++){
            System.out.print("," + Util.generateRandomArray(len , 0, 2));
        }
        System.out.println("]");
    }
}
