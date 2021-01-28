package com.nullzl.leetcode400;

public class LeetCode343 {

    public int integerBreak(int n) {
        if(n < 2 || n > 58)
            throw new IllegalArgumentException();
        int[] rs = new int[n];
        rs[0] = 1;
        int len,temp;
        for(int i = 2; i <= n;i++ ){
            len = i >> 1;
            temp = 0;
            for(int j = 1 ; j <= len ; j++){
                temp = Math.max(temp,Math.max(rs[j-1],j) * Math.max(rs[i-j-1],i-j));
            }
            rs[i - 1] = temp;
        }
        return rs[n-1];
    }
    public static void main(String[] args){
        System.out.print(new LeetCode343().integerBreak(10));
    }
}
