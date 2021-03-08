package com.nullzl.leetcode100;

public class LeetCode41 {

    private void swap(int[] nums,int i , int j){
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    //使用数组自身作为bitmap
    public int firstMissingPositive(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 1;
        int rs,k = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0 && nums[i] <= nums.length)
                swap(nums,++k,i);
        }
        int max = k + 1;
        for(int i = 0 ; i <= k ; i++){
            if(nums[i] <= 0)
                continue;
            int temp = nums[i];
            nums[i] = -1;
            while(temp > 0 && temp <= max){
                int next = nums[temp - 1];
                nums[temp - 1] = 0;
                temp = next;
            }
        }
        for(rs = 0; rs <= k ; rs++){
            if(-1 == nums[rs])
                break;
        }
        return rs + 1;
    }
}
