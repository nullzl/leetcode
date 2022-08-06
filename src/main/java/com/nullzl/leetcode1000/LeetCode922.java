package com.nullzl.leetcode1000;

public class LeetCode922 {

    private void swap(int[] nums,int i , int j){
        if(i < nums.length && j < nums.length && i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0 , j = 1;
        while(i < nums.length && j < nums.length){
            while(i < nums.length && 0 == (nums[i] & 1)) i += 2;
            while(j < nums.length && 0 != (nums[j] & 1)) j += 2;
            swap(nums,i,j);
        }
        return nums;
    }
}
