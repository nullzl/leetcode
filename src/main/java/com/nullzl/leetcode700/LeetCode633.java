package com.nullzl.leetcode700;

public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        long min = 0;
        long max = (int)Math.sqrt(c);
        long target = c;
        while(min <= max){
            long sum = min * min + max * max;
            if(sum == target)
                return true;
            if(sum < target)
                min++;
            else
                max--;
        }
        return false;
    }
}
