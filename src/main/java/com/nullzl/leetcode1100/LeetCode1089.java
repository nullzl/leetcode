package com.nullzl.leetcode1100;

import com.nullzl.util.Util;

public class LeetCode1089 {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for(int n : arr)
            count += (0 == n ? 1 : 0);
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            if(0 == arr[i])
                count--;
            int pos = i + count;
            if(pos < arr.length)
                arr[pos] = arr[i];
            if(0 == arr[i] && pos + 1 < arr.length)
                arr[pos + 1] = arr[i];
        }
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(1000,0,9));
    }

}
