package com.nullzl.leetcode600;

import java.util.Random;

public class LeetCode564 {

    public String nearestPalindromic(String n) {

        return "";


    }

    public static void main(String[] args){
        Random r =new Random();
        int len = r.nextInt(18) + 1;
        System.out.print("\"" + (r.nextInt(9) + 1));

        for(int i = 1 ; i < len ; i ++){
            System.out.print(r.nextInt(10));
        }
        System.out.println("\"");
    }
}
