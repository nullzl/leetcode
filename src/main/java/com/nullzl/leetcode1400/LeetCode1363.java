package com.nullzl.leetcode1400;

import com.nullzl.util.Util;

public class LeetCode1363 {

    public String largestMultipleOfThree(int[] digits) {
        int left = 0;
        int[] nums = new int[10];
        for(int d : digits){
            nums[d]++;
            left = (left + d) % 3;
        }

        if(2 == left){
            for(int i = 2 ; left > 0 && i < 10 ; i += 3){
                if(nums[i] > 0){
                    nums[i]--;
                    left = 0;
                }
            }
        }
        if(left > 0){
            for(int i = 1 ; left > 0 && i < 10 ; i += 3){
                int t = Math.min(nums[i],left);
                nums[i] -= t;
                left -= t;
            }
        }
        if(left == 2)
            return "";
        else if(1 == left)
            left = 2;
        for(int i = 2 ; left > 0 && i < 10 ; i+= 3){
            int t = Math.min(nums[i],left);
            nums[i] -= t;
            left -= t;
        }
        if(left > 0)
            return "";
        StringBuilder builder = new StringBuilder();
        for(int i = 9 ; i > 0 ; i--){
            while(nums[i] > 0){
                builder.append((char)('0' + i));
                nums[i]--;
            }
        }
        if(nums[0] > 0 && builder.length() == 0)
            return "0";
        while(nums[0] > 0){
            builder.append('0');
            nums[0]--;
        }
        return builder.toString();
    }
    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,0,10));
    }
}
