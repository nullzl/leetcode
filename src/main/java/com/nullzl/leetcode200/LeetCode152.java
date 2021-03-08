package com.nullzl.leetcode200;

public class LeetCode152 {

    public int maxProduct(int[] nums) {

        if(null == nums)
            return 0;
        int num = 1;
        int max = Integer.MIN_VALUE;
        int negative = 0;
        for(int i = 0 ; i < nums.length ; i++){
            num *= nums[i];
            if(num > max)
                max = num;
            if(0 == num){
                num = 1;
                negative = 0;
            }else if(num < 0){
                if(0 == negative){
                    negative = num;
                }else{
                    int temp = num / negative;
                    if(temp > max)
                        max = temp;
                }

            }
        }
        return max;
    }
}
