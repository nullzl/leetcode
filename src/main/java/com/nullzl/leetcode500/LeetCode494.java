package main.java.com.nullzl.leetcode500;

public class LeetCode494 {

    /**
     * 递归解法
     * 利用初始数组和小于1000，可确定可达到的s范围-1000，到1000，所以也可使用动态规划
     */

    public int sumWays(int[] nums,int k, int s){
        if(-1 == k){
            if(0 == s)
                return 1;
            else
                return 0;
        }

        return sumWays(nums,k-1,s + nums[k]) +
                sumWays(nums,k-1,s -nums[k]);
    }

    public int findTargetSumWays(int[] nums, int S) {

        return sumWays(nums,nums.length - 1,S);

    }
}
