package com.nullzl.leetcode600;

import java.util.HashMap;

public class LeetCode560 {


    /**
     * sum[i,j]表示i到j的和，即子数组i到j
     * sum[i,j] = sum[0,j] - sum[0,i-1]
     * 基本思路：将sum[0,i]存储在map中，当处理第j个元素时
     *      查看map中是否有数字：sum[0,j] - k
     *      凡时和为此数的下边，到j都构成一个满足条件的子数组
     */
    public int subarraySum(int[] nums, int k) {

        if(null == nums)
            throw new IllegalArgumentException();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            count += map.getOrDefault(sum - k ,0);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
