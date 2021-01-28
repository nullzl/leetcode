package com.nullzl.leetcode700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int i,j,left,right;
        if(arr[0] >= x){
            i= 0 ;
            j = i + k - 1;
        }else if(arr[arr.length - 1] <= x){
            j = arr.length - 1;
            i = arr.length - k;
        }else{
            i = Arrays.binarySearch(arr,x);
            if(i < 0)
                i = -i - 1;
            j = i;
        }
        left = i - 1 >= 0 ? Math.abs(arr[i - 1] - x) : Integer.MAX_VALUE;
        right = Math.abs(arr[j] - x);
        while(j - i < k){
            if(left <= right){
                i--;
                left = i - 1 >= 0 ? Math.abs(arr[i - 1] - x) : Integer.MAX_VALUE;
            }else{
                j++;
                right = j < arr.length ? Math.abs(arr[j] - x) : Integer.MAX_VALUE;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(;i < j ; i++){
            list.add(arr[i]);
        }
        return list;
    }
}
