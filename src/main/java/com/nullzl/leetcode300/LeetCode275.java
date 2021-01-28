package com.nullzl.leetcode300;

public class LeetCode275 {

    private int search(int[] nums,int s,int e){
        if(s > e)
            return nums.length;
        if(s == e){
            if(nums[s] < nums.length - s)
                return nums.length - s - 1;
            else
                return nums.length;
        }
        if(e - s == 1){
            if(nums[e] < nums.length - e)
                return nums.length - e - 1;
            else if(nums[s] < nums.length - s)
                return nums.length - s - 1;
            else
                return nums.length;
        }
        int mid = s + ((e - s) >> 1);
        if(nums[mid] < nums.length - mid)
            return search(nums,mid,e);
        else
            return search(nums,s,mid-1);
    }

    public int hIndex(int[] citations) {
        if(null == citations)
            return 0;
        return search(citations,0,citations.length - 1);
    }
}
