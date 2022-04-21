package com.nullzl.offer;

public class Offer17 {

    public int[] printNumbers(int n) {

        if(0 == n)
            return new int[0];

        int len = 9;
        for(int i = 1; i < n ; i++){
            len = len * 10 + 9;
        }
        int[] rs = new int[len];
        for(int i = 0 ; i < len ; i++){
            rs[i] = i + 1;
        }
        return rs;
    }
}
