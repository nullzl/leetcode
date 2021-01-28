package com.nullzl.leetcode500;

public class LeetCode441 {

    public int arrangeCoins(int n) {
        if(0 == n)
            return n;

        int e = (int)(1.5 * ((int)Math.sqrt(n) + 1));
        int  s = 1;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            long amount = (mid * (mid + 1L))/2;
            if(amount == n)
                return mid;
            if(amount > n)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s - 1;
    }

    public static void main(String[] args){

        System.out.println(new LeetCode441().arrangeCoins(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }
}
