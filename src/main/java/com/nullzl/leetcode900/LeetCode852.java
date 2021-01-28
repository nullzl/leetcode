package com.nullzl.leetcode900;

public class LeetCode852 {

    public int peakIndexInMountainArray(int[] arr) {

        //山脉的范围为1到arr.length - 2
        int s = 1;
        int e = arr.length - 2;

        while(s <= e){
            int mid = s + ((e -s) >> 1);
            if(arr[mid] > arr[mid + 1])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;

    }
}
