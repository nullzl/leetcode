package com.nullzl.leetcode100;

public class LeetCode55 {

    public boolean canJump(int[] nums) {
        if(null == nums || 0 == nums.length)
            return false;

        int maxLen = 0;
        for(int i = 0; i < nums.length && i <=maxLen ; i++){
            int len = i + nums[i];
            if(len >= nums.length - 1)
                return true;
            if(len > maxLen)
                maxLen = len;
        }
        return false;
    }
}
