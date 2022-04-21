package com.nullzl.leetcode500;

public class LeetCode440 {





    public int findKthNumber1(int n, int k) {

        int prefix = 1;
        int count = 0;
        while (true){
            if(count + 1 == k)
                return prefix;
            int next = prefix + 1;
            int tmp = 0;
            int t = 1;
            while(prefix <= n / t){
                tmp += Math.min(n + 1, next * t) - prefix * t;
                t *= 10;
            }
            if(count + tmp >= k){
                prefix *= 10;
                count++;
            }else{
                prefix++;
                count += tmp;
            }
        }
    }
}
