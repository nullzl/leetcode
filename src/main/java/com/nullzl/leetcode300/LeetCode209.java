package com.nullzl.leetcode300;

public class LeetCode209 {

    public int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || null == nums || 0 == nums.length)
            return 0;

        int sum = nums[0];
        int left = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while(true){
            if(sum >= s){
                int len = i - left + 1;
                min = Math.min(len,min);
                sum -= nums[left++];
            }else{
                if(++i < nums.length)
                    sum += nums[i];
                else
                    break;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode209().minSubArrayLen(
                11,
                new int[]{
                        1,2,3,4,5
                }
        ));
    }
}
