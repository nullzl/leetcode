package com.nullzl.leetcode400;

import java.util.*;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        if(null == nums1 || null == nums2 || 0 == nums1.length || 0 == nums2.length)
            return new int[0];

        if(nums2.length < nums1.length)
            return intersection(nums2,nums1);

        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(set::add);
        int[] rs = new int[set.size()];
        int i,j;
        for(i = 0,j = 0 ; i < nums2.length ; i++){
            if(set.contains(nums2[i])){
                rs[j++] = nums2[i];
                set.remove(nums2[i]);
            }
        }

        int[] ns = new int[j];
        System.arraycopy(rs,0,ns,0,j);
        return ns;

    }
}
