package com.nullzl.leetcode400;

public class LeetCode371 {

    public int getSum(int a, int b) {

        int next = 0;
        int rs = 0;
        int exp = 1;

        for(int i = 1 ; i <= 32 ; i++){
            int exp1 = a & exp;
            int exp2 = b & exp;
            rs = rs | (exp1 ^ exp2 ^ next);
            next = (exp1 & exp2) | (exp1 & next) | (next & exp2);
            exp = exp << 1;
            next = next << 1;
        }
        return rs;
    }

    public static void main(String[] args){
        System.out.print(new LeetCode371().getSum(0,0));
    }
}
