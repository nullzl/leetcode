package com.nullzl.leetcode400;

public class LeetCode376 {

    public int wiggleMaxLength(int[] nums) {
        if(null == nums)
            return 0;
        if(nums.length < 2)
            return nums.length;
        int i ;
        int count = 1;
        for(i = 1 ; i < nums.length && nums[i] == nums[i-1] ; i++);
        if(i == nums.length)
            return count;
        boolean flag = nums[i] - nums[i-1] > 0 ? true : false;
        for(; i < nums.length ; i++){
            if(nums[i] == nums[i - 1])
                continue;
            if(flag && nums[i] - nums[i-1] < 0){
                count++;
                flag = false;
            }else if(!flag && nums[i] - nums[i-1] > 0){
                count++;
                flag = true;
            }
        }
        return ++count;
    }
}
