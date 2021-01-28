package com.nullzl.leetcode300;

import java.util.LinkedList;
import java.util.List;

public class LeetCode228 {

    private void addRange(List<String> rs,int s ,int e){
        if(s == e)
            rs.add(String.valueOf(s));
        else
            rs.add(s + "->" + e);
    }
    public List<String> summaryRanges(int[] nums) {

        List<String> rs = new LinkedList<>();
        if(null == nums || 0 == nums.length)
            return rs;

        int low = nums[0];
        int high = low;
        for(int i = 1 ; i < nums.length ; i++){
            if(1 == nums[i] - high)
                high = nums[i];
            else{
                addRange(rs,low,high);
                low = nums[i];
                high = nums[i];
            }
        }
        addRange(rs,low,high);
        return rs;
    }
}
