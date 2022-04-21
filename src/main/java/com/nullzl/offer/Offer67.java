package com.nullzl.offer;

import java.util.Arrays;

public class Offer67 {

    public int[] constructArr(int[] a) {

        if(null == a || 0 == a.length)
            return new int[0];

        int[] rs = new int[a.length];
        Arrays.fill(rs,1);
        int num = 1;
        for(int i = 0 ; i < a.length ; i++){
            rs[i] *= num;
            num *= a[i];
        }
        num = 1;
        for(int i = a.length - 1 ; i >= 0 ; i--){
            rs[i] *= num;
            num *= a[i];
        }
        return rs;
    }
}
