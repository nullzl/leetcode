package com.nullzl.leetcode1300;

import java.util.Arrays;

public class LeetCode1288 {

    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals,(op1,op2) ->{
            if(op1[0] == op2[0])
                return -Integer.compare(op1[1],op2[1]);
            return Integer.compare(op1[0],op2[0]);
        });
        int[] cur = intervals[0];
        int count = 0;
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] >= cur[0] && intervals[i][1] <= cur[1])
                count++;
            else
                cur = intervals[i];
        }
        return intervals.length - count;
    }
}
