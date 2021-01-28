package com.nullzl.leetcode1000;

import java.util.Arrays;

public class LeetCode914 {

    private int gcd(int a,int b){
        if(0 == b)
            return a;
        if(a % b == 0)
            return b;
        return gcd(b,a % b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        if(null == deck || deck.length < 2)
            return false;
        int[] map = new int[10000];
        Arrays.stream(deck).forEach(num -> map[num]++);
        int rs = 0;
        for(int i = 0 ; i < map.length && 1 != rs ; i++){
            if(0 != map[i])
                rs = gcd(map[i],rs);
        }
        return rs != 1;
    }
}
