package com.nullzl.interview;

public class LeetCode62 {
    public int lastRemaining(int n, int m) {

        int rs = 0;
        for(int i = 2; i <= n ; i++){
            rs = (rs + m) % i;
        }
        return rs;
    }
}
