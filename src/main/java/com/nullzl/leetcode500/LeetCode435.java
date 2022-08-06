package com.nullzl.leetcode500;

import java.util.Arrays;

public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(op1,op2) ->{
            return Integer.compare(op1[1],op2[1]);
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0 ; i < intervals.length ; i++){
            if(intervals[i][0] < end)
                count++;
            else
                end = intervals[i][1];
        }
        return count;
    }
}
