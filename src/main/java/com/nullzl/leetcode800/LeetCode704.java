package com.nullzl.leetcode800;

public class LeetCode704 {

    public int search(int[] nums, int target) {

        if(null == nums || 0 == nums.length)
            return -1;

        int s = 0 ;
        int e = nums.length - 1;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            if(target == nums[mid])
                return mid;
            if(target < nums[mid])
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;

    }
}
