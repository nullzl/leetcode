package com.nullzl.leetcode300;

import java.util.BitSet;

public class LeetCode204 {

    public int countPrimes(int n) {

        if(n <= 2)
            return 0;
        n = n-1;
        BitSet set = new BitSet(n);
        int len = (int)Math.sqrt(n);
        int sum,temp;
        for(int i = 3 ; i <= len ; i+=2){
            if(set.get(i-1))
                continue;
            temp = 2 * i;
            sum = temp;
            while(sum > 0 && sum <= n - i){
                set.set(sum + (i - 1));
                sum += temp;
            }
        }

        int count = 0;
        for(int i = 2 ; i > 0 && i < n ; i+=2){
            if(!set.get(i))
                count++;
        }
        return count + 1;
    }

    public static void main(String[] args){
        System.out.print(new LeetCode204().countPrimes(0x7FFFFFFF));
    }
}
