package com.nullzl.leetcode100;

public class LeetCode75 {
    public void sortColors(int[] nums) {

        if(null == nums)
            return ;
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0 ; i <= right ; ){
            if(0 == nums[i]){
                nums[left++] = 0;
                i++;
            }else if(1 == nums[i]){
                i++;
            }else{
                nums[i] = nums[right];
                nums[right--] = 2;
            }
        }
        for(int i = left ; i <= right ; i++){
            nums[i] = 1;
        }
    }
}
