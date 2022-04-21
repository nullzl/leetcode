package com.nullzl.leetcode800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode763 {

    public List<Integer> partitionLabels(String s) {

        int[][] regions = new int['z' - 'a' + 1][2];
        for(int[] r : regions){
            r[0] = Integer.MAX_VALUE;
            r[1] = Integer.MIN_VALUE;
        }
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            int index = arr[i] - 'a';
            regions[index][0] = Math.min(regions[index][0],i);
            regions[index][1] = Math.max(regions[index][1],i);
        }
        Arrays.sort(regions,(op1,op2) ->{
            return op1[0] > op2[0] ? 1 : -1;
        });
        int[] region = regions[0];
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < regions.length && regions[i][0] != Integer.MAX_VALUE ; i++){
            if(regions[i][0] < region[1]){
                region[1] = Math.max(region[1],regions[i][1]);
            }else{
                list.add(region[1] - region[0] + 1);
                region = regions[i];
            }
        }
        if(region[0] != Integer.MAX_VALUE)
            list.add(region[1] - region[0] + 1);
        return list;
    }
}
