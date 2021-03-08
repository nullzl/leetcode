package com.nullzl.leetcode400;

public class LeetCode326 {

    public boolean isPowerOfThree(int n) {

        if(n <= 0)
            return false;

        while(1 != n){
            if(0 != n % 3)
                return false;
            n = n / 3;
        }
        return true;
    }
}
