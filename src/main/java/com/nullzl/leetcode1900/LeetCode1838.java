package com.nullzl.leetcode1900;

import java.util.Arrays;

public class LeetCode1838 {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0  , j = 0;
        long sum = 0;
        int max = 0;
        for(; j < nums.length ; j++){
            sum += nums[j];
            while(i <= j && k + sum < (long)nums[j] * (j - i + 1))
                sum -= nums[i++];
            max = Math.max(max, j - i  + 1);
        }
        return max;
    }
}
