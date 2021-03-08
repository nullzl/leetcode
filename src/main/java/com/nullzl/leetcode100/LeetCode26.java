package com.nullzl.leetcode100;

public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        if(null == nums)
            return 0;
        if(1 == nums.length)
            return 1;

        int size = 0;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] == nums[i - 1])
                size++;
            nums[i - size] = nums[i];
        }
        return nums.length - size;
    }
}
