package com.nullzl.leetcode1000;

import java.util.Arrays;

public class LeetCode955 {

    public int minDeletionSize(String[] strs) {

        char[][] arr =new char[strs.length][];
        for(int i= 0 ; i < arr.length ; i++)
            arr[i] = strs[i].toCharArray();

        int count = 0;
        boolean[] rows = new boolean[arr.length];
        rows[0] = true;
        boolean loop = true;
        for(int j = 0 ; j < arr[0].length && loop ; j++){
            boolean[] tmp = Arrays.copyOf(rows,rows.length);
            int i = 0;
            loop = false;
            for(; i < arr.length ; i++){

                if(tmp[i])
                    continue;
                if(arr[i][j] < arr[i-1][j]){
                    loop = true;
                    count++;
                    break;
                }else if(arr[i][j] > arr[i-1][j])
                    tmp[i] = true;
                else
                    loop = true;
            }
            if(i == arr.length)
                rows = tmp;
        }
        return count;
    }
}
