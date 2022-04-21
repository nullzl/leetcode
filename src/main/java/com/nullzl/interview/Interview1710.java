package com.nullzl.interview;

public class Interview1710 {

    public int majorityElement(int[] nums) {

        if(null == nums || 0 == nums.length)
            return -1;

        int target = 0;
        int count = 0;
        for(int num : nums){
            if(0 == count){
                target = num;
                count = 1;
            }else if(num == target)
                count++;
            else
                count--;
        }
        if(0 == count)
            return -1;
        count = 0;
        for(int num : nums){
            if(num == target)
                count++;
        }

        return count > (nums.length >>> 1) ? target : -1;

    }
}
