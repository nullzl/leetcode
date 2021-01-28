package com.nullzl.leetcode600;

import java.util.HashSet;

public class LeetCode523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        if(Integer.MIN_VALUE == k || null == nums || 2 > nums.length)
            return false;

        if(0 == k){
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] == nums[i-1] && 0 == nums[i])
                    return true;
            }
            return false;
        }

        HashSet<Integer> set = new HashSet<>(nums.length);
        k = Math.abs(k);
        nums[0] %= k;
        for(int i = 1 ; i < nums.length ; i++){
            nums[i] = (nums[i] + nums[i-1]) % k;

            if(0 == nums[i] || set.contains(nums[i]))
                return true;

            set.add(nums[i-1]);
        }
        return false;
    }


    public static void main(String[] args){

    }

}
