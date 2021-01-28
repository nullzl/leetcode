package main.java.com.nullzl.leetcode100;

public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {

        if(null == nums || 0 == nums.length)
            return 0;
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;

    }
}
