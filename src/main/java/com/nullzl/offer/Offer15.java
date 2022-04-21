package com.nullzl.offer;

public class Offer15 {

    public int hammingWeight(int n) {

        int count = 0;
        while(0 != n){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new Offer15().hammingWeight(-3));
    }
}
