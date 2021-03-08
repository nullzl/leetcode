package com.nullzl.leetcode100;

public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {

        int[] rs = {-1,-1};
        int left = 0,right =nums.length - 1;
        if(null == nums || 0 == nums.length || target < nums[0] || target > nums[right])
            return rs;

        while(left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                rs[0] = mid;
                rs[1] = mid;
                break;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(-1 == rs[0])
            return rs;
        for(; rs[0] >= 0 && nums[rs[0]] == target ; rs[0]--);
        rs[0]++;
        for(; rs[1] < nums.length && target == nums[rs[1]] ; rs[1]++);
        rs[1]--;
        return rs;



    }
}
