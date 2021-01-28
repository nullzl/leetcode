package com.nullzl.interview;

public class LeetCode1716 {

    public int massage(int[] nums) {

        if(null == nums)
            return 0;
        int pre1 = 0;
        int pre2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int temp = Math.max(pre2,pre1 + nums[i]);
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
}
