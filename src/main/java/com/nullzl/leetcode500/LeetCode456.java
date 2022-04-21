package com.nullzl.leetcode500;

public class LeetCode456 {
    public boolean find132pattern(int[] nums) {
        if(null == nums || nums.length < 3)
            return false;
        //使用数组来模拟栈，效率更高
        int[] stk = new int[nums.length];
        int top = -1;
        //保存k，递减栈中弹出的元素最大值，被弹出，所以一定存在j，将k弹出
        int max = Integer.MIN_VALUE;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            //存在i，nums[i] < nums[k]
            if(max > nums[i])
                return true;
            while(-1 != top && nums[i] > stk[top]){
                max = Math.max(max,stk[top--]);
            }
            stk[++top] = nums[i];
        }
        return false;
    }
}
