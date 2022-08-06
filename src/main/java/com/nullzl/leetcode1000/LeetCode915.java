package com.nullzl.leetcode1000;

public class LeetCode915 {

    public int partitionDisjoint(int[] nums) {
        int[] min = new int[nums.length];
        min[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0 ; i--)
            min[i] = Math.min(nums[i],min[i + 1]);
        int max = nums[0];
        for(int i = 0 ; i < nums.length - 1 ; i++){
            max = Math.max(max,nums[i]);
            if(max <= min[i + 1])
                return i + 1;
        }
        return 0;
    }
}
