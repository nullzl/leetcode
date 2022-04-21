package com.nullzl.leetcode1000;

public class LeetCode977 {

    public int[] sortedSquares(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = nums[i] * nums[i];
        }
        int i = 0 , j = nums.length - 1, pos = nums.length - 1;
        int[] ans = new int[nums.length];
        while(i <= j){
            if(nums[i] > nums[j])
                ans[pos--] = nums[i++];
            else
                ans[pos--] = nums[j--];
        }
        return ans;
    }
}
