package main.java.com.nullzl.leetcode100;

public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        if(null == nums || 0 == nums.length)
            return 0;

        int size = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == val)
                size++;
            else
                nums[i - size] = nums[i];
        }
        return nums.length - size;

    }

}
