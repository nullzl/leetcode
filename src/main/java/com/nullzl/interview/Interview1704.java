package com.nullzl.interview;

public class Interview1704 {
    public int missingNumber(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int pos = -1;
        for(int i = 0 ; i < nums.length ; ){
            if(nums[i] == nums.length)
                pos = i++;
            else if(nums[i] != i){
                int j = nums[i];
                nums[i] = nums[j] ^ nums[i];
                nums[j] = nums[j] ^ nums[i];
                nums[i] = nums[j] ^ nums[i];
            }else
                i++;
        }
        return -1 == pos ? nums.length : pos;
    }
}
