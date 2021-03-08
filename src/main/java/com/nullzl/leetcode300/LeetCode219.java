package com.nullzl.leetcode300;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;

public class LeetCode219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(null == nums || 0 == nums.length || 1 == nums.length || k < 1)
            return false;
        HashSet<Integer> set = new HashSet<>();
        int i = 0,j = 0;
        for(; j < nums.length ; j++){
            if(j - i + 1 > k + 1){
                set.remove(nums[i++]);
            }
            if(set.contains(nums[j]))
                return true;
            set.add(nums[j]);
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode219().containsNearbyDuplicate(
                new int[] {
                        1,0,1,1
                },2

        ));
    }
}
