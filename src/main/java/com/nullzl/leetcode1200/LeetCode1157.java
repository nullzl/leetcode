package com.nullzl.leetcode1200;

import java.util.Arrays;

public class LeetCode1157 {

    public int[] arr;
    public int max = Integer.MIN_VALUE;
    public int[] count;

    public LeetCode1157(int[] arr) {
        this.arr = arr;
        for(int a : arr)
            max = Math.max(max,a);
        count = new int[max + 1];
    }

    public int query(int left, int right, int threshold) {
        Arrays.fill(count,0);
        for(int i = left ; i <= right;i++){
            count[arr[i]]++;
            if(count[arr[i]] >= threshold)
                return arr[i];
        }
        return -1;
    }
}
