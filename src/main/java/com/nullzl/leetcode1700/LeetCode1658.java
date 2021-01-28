package com.nullzl.leetcode1700;

import java.util.HashMap;

public class LeetCode1658 {
    public int minOperations1(int[] nums, int x) {
        for(int i = 1 ; i < nums.length ; i++){
            nums[i] += nums[i-1];
        }

        if(nums[nums.length - 1] < x)
            return -1;
        if(nums[nums.length - 1] == x)
            return nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        int sum = nums[nums.length - 1] - x;
        for(int i= 0 ; i < nums.length ; i++){
            int tmp = nums[i] - sum;
            Integer v = map.get(tmp);
            if(null != v){
                max = Math.max(max,i - v);
            }
            map.put(nums[i],i);
        }

        return 0 == max ? -1 : nums.length - max;
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0 ;
        for(int n : nums)
            sum += n;
        int target = sum - x;
        if(target < 0)
            return -1;
        if(target == 0)
            return nums.length;
        int left = 0;
        int right = 0;
        sum = 0;
        int max = 0;
        while(right < nums.length){
            sum += nums[right++];
            while(sum > target){
                sum -= nums[left++];
            }
            if(sum == target)
                max = Math.max(max,right - left);
        }
        return 0 == max ? -1 : nums.length - max;
    }

    public static  void main(String[] args){
        new LeetCode1658().minOperations(new int[]{5,2,3,1,1},5);
    }
}
