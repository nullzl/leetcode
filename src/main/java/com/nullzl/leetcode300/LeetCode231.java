package com.nullzl.leetcode300;

public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        return 0 == (n & (n - 1));
    }

    public boolean isPowerOfTwo1(int n) {

        int exp = 0x80000000;
        if(0 != (exp & n))
            return false;
        exp = exp >>> 1;
        int count = 0;
        for(int i = 1; i <= 31 ; i++){
            if(0 != (n & exp))
                count++;
            exp = exp >>> 1;
        }
        if(1 == count)
            return true;
        return false;
    }

    public static void main(String[] args){
        System.out.print(new LeetCode231().isPowerOfTwo(16));
    }
}
