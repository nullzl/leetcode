package com.nullzl.leetcode300;

import java.util.Arrays;
import java.util.TreeSet;

public class LeetCode220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(null == nums || 0 == nums.length || k < 1 || t < 0)
            return false;
        TreeSet<Integer> tree = new TreeSet<>();
        int i = 0 , j = 0;
        for(; j < nums.length ; j++){
            if(j - i > k ){
                tree.remove(nums[i++]);
            }
            if(tree.contains(nums[j]))
                return true;
            Integer higher = tree.higher(nums[j]);
            if(null != higher && higher - (long)nums[j] <= t)
                return true;
            Integer lower = tree.lower(nums[j]);
            if(null != lower && (long)nums[j] - lower <= t)
                return true;
            tree.add(nums[j]);
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode220().containsNearbyAlmostDuplicate(
                new int[]{-1,0x7FFFFFFF},
                1,0x7FFFFFFF
        ));
    }
}
