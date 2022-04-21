package com.nullzl.leetcode1000;

import java.util.ArrayList;
import java.util.List;

public class LeetCode986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if(null == firstList || null == secondList
                || 0 == firstList.length|| 0 == secondList.length)
            return new int[0][0];

        List<int[]> list = new ArrayList<>();
        for(int i = 0,j = 0 ; i < firstList.length && j < secondList.length ; i++){
            for(;j < secondList.length && secondList[j][1] <= firstList[i][1] ; j++){
                int low = Math.max(firstList[i][0],secondList[j][0]);
                int high = Math.min(firstList[i][1],secondList[j][1]);
                if(low <= high)
                    list.add(new int[]{low,high});
            }
            if(j < secondList.length && secondList[j][0] <= firstList[i][1]){
                int low = Math.max(firstList[i][0],secondList[j][0]);
                int high = Math.min(firstList[i][1],secondList[j][1]);
                list.add(new int[]{low,high});
            }
        }
        return list.toArray(new int[0][2]);
    }
}
