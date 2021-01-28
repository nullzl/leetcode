package main.java.com.nullzl.leetcode100;

public class LeetCode33 {

    public int search(int[] nums, int target) {
        if(null == nums || 0 == nums.length)
            return -1;

        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >> 2;
            if(nums[mid] == target)
                return mid;
            if(target < nums[mid]){
                if(nums[right] < nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }else{
                if(nums[right] >= nums[mid] && target >= nums[left])
                    right = mid -1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
