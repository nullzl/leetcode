package main.java.com.nullzl.leetcode300;

public class LeetCode238 {


    /**
     * 解法1：使用额外的数组left和right。
     *       left[i]= nums[0] * ...* nums[i-1] right[i] = nums[n-1] * ... * nums[i+1]
     *       rs[i] = left[i] * rith[i]
     * 解法2：优化使用常数额外空间。
     *       第一次遍历rs[i] = rs[i-1] * nums[i-1]
     *       第二次遍历 初始exp=1，rs[i] = rs[i] * exp,exp=exp*nums[i]
     */
    public int[] productExceptSelf(int[] nums) {

        if(null == nums  || nums.length < 1)
            throw new IllegalArgumentException();

        int[] rs = new int[nums.length];
        int exp = 1;
        for(int i = 0 ; i < nums.length ; i++){
            rs[i] = exp;
            exp *= nums[i];
        }
        exp = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            rs[i] = rs[i] * exp;
            exp *= nums[i];
        }
        return rs;
    }
}
