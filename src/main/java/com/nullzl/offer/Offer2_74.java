package com.nullzl.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer2_74 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(op1,op2) ->{
            return Integer.compare(op1[0],op2[0]);
        });

        int s = intervals[0][0];
        int e = intervals[0][1];
        List<int[]> lists = new ArrayList<>(intervals.length);
        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] >= s && intervals[i][0] <= e){
                e = Math.max(e,intervals[i][1]);
            }else{
                lists.add(new int[]{s,e});
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        lists.add(new int[]{s,e});
        return lists.toArray(new int[0][]);
    }
}
