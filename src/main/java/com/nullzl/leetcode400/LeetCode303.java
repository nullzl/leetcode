package com.nullzl.leetcode400;

public class LeetCode303 {

    int[] sums;

    public LeetCode303(int[] nums) {
        sums = new int[nums.length];
        if(nums.length > 0)
            sums[0] = nums[0];
        for(int i = 1 ;i < nums.length ; i++)
            sums[i] = sums[i-1] + nums[i];
    }

    public int sumRange(int i, int j) {
        if(0 == sums.length)
            return 0;
        int s = i == 0 ? 0 : sums[i-1];
        return sums[j] - s;
    }
}
