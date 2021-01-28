package main.java.com.nullzl.leetcode400;

public class LeetCode334 {

    public boolean increasingTriplet(int[] nums) {

        if(null == nums || nums.length < 3)
            return false;

        int min = nums[0];
        int increasingTwo = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length ; i++){
            if(nums[i] < min){
                min = nums[i];
            }else if(nums[i] > min && nums[i] < increasingTwo){
                increasingTwo = nums[i];
            }else if(nums[i] > increasingTwo)
                return true;
        }
        return false;
    }
}
