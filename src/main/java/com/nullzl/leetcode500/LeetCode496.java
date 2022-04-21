package com.nullzl.leetcode500;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        Arrays.fill(map,-1);
        int[] ans = new int[nums1.length];
        int size = 0;
        for(int i = 0 ; i < nums1.length ; i++)
            map[nums1[i]] = i;
        LinkedList<Integer> stk = new LinkedList<>();
        for(int i = nums2.length - 1 ; i >= 0 && size < nums1.length ; i--){
            while(!stk.isEmpty() && stk.peek() <= nums2[i])
                stk.pop();
            if(-1 != map[nums2[i]]){
                ans[map[nums2[i]]] = stk.isEmpty() ? -1 : stk.pop();
                size++;
            }
            stk.push(nums2[i]);
        }
        return ans;
    }
}
