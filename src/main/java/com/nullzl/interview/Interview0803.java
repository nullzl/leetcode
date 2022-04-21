package com.nullzl.interview;

public class Interview0803 {

    public int findMagicIndex(int[] nums) {

        if(null == nums || 0 == nums.length)
            return -1;

        for(int i = 0 ; i < nums.length ; ){
            if(i == nums[i])
                return i;
            i = nums[i] < i ? i + 1 : nums[i];
        }
        return -1;
    }
}
