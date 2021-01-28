package com.nullzl.leetcode300;

public class LeetCode263 {

    public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        if(1 == num)
            return true;
        while(0 == (1 & num))
            num = num >> 1;
        while(0 == num % 3)
            num = num / 3;
        while(0 == num % 5)
            num = num / 5;
        return num == 1;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode263().isUgly(14));
    }
}
