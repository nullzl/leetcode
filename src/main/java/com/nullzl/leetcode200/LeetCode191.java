package com.nullzl.leetcode200;

public class LeetCode191 {

    public int hammingWeight(int n) {

        int count = 0 ;
        for(int i = 0 ; i < 32 ; i++){
            if(0 != (1 & n))
                count ++;
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode191().hammingWeight(5));
    }
}
