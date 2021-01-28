package com.nullzl.leetcode1000;

public class LeetCode945 {

    public int minIncrementForUnique(int[] A) {

        int[] map = new int[40000];
        for(int i = 0; i < A.length ; i++){
            map[A[i]]++;
        }
        int count = 0;
        for(int i = 0 ; i < 39999 ; i++){
            if(map[i] > 1){
                count += map[i] - 1;
                map[i+1] += map[i] - 1;
            }
        }
        count += (map[39999] > 1 ? (map[39999] * (map[39999] - 1)) / 2 : 0);
        return count;
    }

}
