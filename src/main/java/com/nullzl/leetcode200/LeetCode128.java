package com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.Iterator;

public class LeetCode128 {

    class Pair{
        int start ;
        int end;
        public Pair(int s,int e){
            start = s;
            end = e;
        }
    }

    public int longestConsecutive(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        HashMap<Integer,Pair> map = new HashMap<Integer,Pair>(nums.length);
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(null != map.get(nums[i]))
                continue;
            Pair left = map.get(nums[i] - 1);
            Pair right = map.get(nums[i] + 1);
            int start = nums[i];
            int end = nums[i];
            if(null != left){
                start = left.start;
            }
            if(null != right){
                end = right.end;
            }
            Pair pair = new Pair(start,end);
            map.put(nums[i] ,pair);
            if(start == nums[i] -1){
                left.end = end;
            }else if(start < nums[i] - 1){
                map.put(start,pair);
            }
            if(end == nums[i] + 1){
                right.start = start;
            }else if(end > nums[i] + 1){
                map.put(end,pair);
            }

            int len = end - start + 1;
            if(len > max)
                max = len;
        }
        return max;

    }
}
