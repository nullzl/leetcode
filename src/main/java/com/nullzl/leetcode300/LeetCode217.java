package main.java.com.nullzl.leetcode300;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode217 {

    public boolean containsDuplicate(int[] nums) {

        if(null == nums || 0 == nums.length || 1 == nums.length)
            return false;

        HashSet<Integer> set = new HashSet<>(nums.length);
        for(int i = 0 ;  i < nums.length ; i++){
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}
