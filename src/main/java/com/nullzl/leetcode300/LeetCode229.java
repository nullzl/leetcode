package com.nullzl.leetcode300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> rs = new ArrayList<>(2);
        if(null == nums || 0 == nums.length)
            return rs;

        int candidate1 = 0,candidate2 = 0,count1 = 0 , count2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(0 == count1 && (0 == count2 || nums[i] != candidate2)){
                candidate1 = nums[i];
                count1 = 1;
            }else if(0 == count2 && (0 == count1 || nums[i] != candidate1)){
                candidate2 = nums[i];
                count2 = 1;
            }else if(candidate1 == nums[i]){
                count1++;
            }else if(candidate2 == nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int k = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == candidate1)
                count1++;
            else if(nums[i] == candidate2)
                count2++;
        }
        if(count1 > k)
            rs.add(candidate1);
        if(count2 > k)
            rs.add(candidate2);
        return rs;
    }
}
