package com.nullzl.leetcode1000;

public class LeetCode991 {

    public int brokenCalc(int startValue, int target) {
        if(startValue >= target)
            return startValue - target;
        int cnt = 0;
        long n = startValue;
        long t = target;
        while(n < t){
            n <<= 1;
            cnt++;
        }
        long delta = n - t;
        long num = 1 << cnt;
        while(0 != num && delta != 0){
            cnt += (delta / num);
            delta = delta % num;
            num >>= 1;
        }
        return cnt;
    }
}
