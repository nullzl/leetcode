package com.nullzl.interview;

public class Interview1611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if(0 == k)
            return new int[0];
        if(shorter == longer)
            return new int[]{shorter * k};

        int[] rs = new int[k + 1];
        rs[0] = k * shorter;
        int delta = longer - shorter;
        for(int i = 1 ; i <= k ; i++){
            rs[i] = rs[i - 1] + delta;
        }
        return rs;
    }
}
