package main.java.com.nullzl.leetcode200;

import java.math.BigInteger;

public class LeetCode190 {

    public int reverseBits(int n) {
        int rs = 0 | (1 & n);
        for(int i = 1 ; i < 32 ; i++){
            n = n >> 1;
            rs = rs << 1;
            rs = rs | (1 & n);
        }
        return rs;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode190().reverseBits(-100));
    }
}
