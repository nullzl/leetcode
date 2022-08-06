package com.nullzl.leetcode500;

import java.util.Arrays;

public class LeetCode452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(op1,op2)->{
            return Integer.compare(op1[1],op2[1]);
        });

        int count  = 1;
        int max = points[0][1];
        for(int i = 1;i < points.length ;i++){
            if(points[i][0] > max){
                max = points[i][1];
                count++;
            }
        }
        return count;
    }
}
