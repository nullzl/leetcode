package com.nullzl.leetcode1100;

public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {

        int i = -1;
        int sum = 0;
        int len = 0;
        for(int j = 0 ;j < nums.length ; j++){
            nums[j] += (j - 1 >= 0 ? nums[j-1] : 0);
            while(i < j && sum > k - j + i + nums[j]) sum = nums[++i];
            len = Math.max(j - i,len);
        }
        return len;
    }
}
