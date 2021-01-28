package main.java.com.nullzl.leetcode200;

public class LeetCode136 {

    public int singleNumber(int[] nums) {

        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
            sum = sum ^ nums[i];
        return sum;

    }
}
