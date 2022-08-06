package com.nullzl.leetcode1300;

public class LeetCode1248 {

    public int numberOfSubarrays(int[] nums, int k) {

        if(null == nums || 0 == nums.length || k < 1 || k > nums.length)
            throw new IllegalArgumentException();
        int amount = 0;
        int len = 1;
        int[] index = new int[nums.length + 2];
        index[0] = -1;
        for(int i = 0; i < nums.length ; i++){
            if(0 != (1 & nums[i]))
                index[len++] = i;
        }
        index[len++] = nums.length;
        for(int i = 1 ; i + k < len ; i++){
            amount += (index[i] - index[i-1]) * (index[i+k]  - index[i+k-1]);
        }
        return amount;
    }
}
