package com.nullzl.leetcode500;

public class LeetCode470 {

    public int rand7(){return 0;}

    public int rand10() {
        int a,b,idx;
        do{
            a = rand7();
            b = rand7();
            idx = (a - 1) * 7 + b - 1;
        }while(idx >= 40);
        return idx / 4 + 1;
    }
}
