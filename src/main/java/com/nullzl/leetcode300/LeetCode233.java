package com.nullzl.leetcode300;

public class LeetCode233 {

    public int countDigitOne(int n) {

        if(n < 1)
            return 0;

        int amount = 0;
        int k = 0;
        int exp = 1;
        int left = n;
        int right = 0;
        int cur;
        while(0 != left){
            cur = left % 10 ;
            left = left / 10;
            k++;
            amount += (left * exp);
            if(1 == cur)
                amount += (right + 1);
            else if(cur > 1){
                amount += exp;
            }
            right = cur * exp + right;
            exp *= 10;
        }
        return amount;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode233().countDigitOne(1410065408));
    }
}
