package com.nullzl.leetcode500;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);
        if(null == nums || 0 == nums.length)
            return ans;
        int len = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            nums[(nums[i] - 1) % len] += len;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > (len << 1) && nums[i] <= len * 3)
                ans.add(i+1);
        }
        return ans;
    }

    public List<Integer> findDuplicates1(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        if(null == nums || 0 == nums.length)
            return ans;

        for(int i = 0 ; i < nums.length ; ){
            if(0 == nums[i] || nums[i] == i + 1) {
                i++;
                continue;
            }
            if(nums[nums[i] - 1] == nums[i]){
                ans.add(nums[i]);
                nums[i++] = 0;
            }else{
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        return ans;
    }
}
