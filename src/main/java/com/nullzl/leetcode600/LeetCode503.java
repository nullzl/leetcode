package com.nullzl.leetcode600;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {

        LinkedList<Integer> stk = new LinkedList<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,Integer.MIN_VALUE);
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && nums[i] >= stk.peek())
                stk.pop();
            ans[i] = stk.isEmpty() ? Integer.MIN_VALUE : stk.peek();
            stk.push(nums[i]);
        }
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(Integer.MIN_VALUE == ans[i]){
                while(!stk.isEmpty() && nums[i] >= stk.peek())
                    stk.pop();
                ans[i] = stk.isEmpty() ? -1 : stk.peek();
                stk.push(nums[i]);
            }
        }
        return ans;
    }
}
