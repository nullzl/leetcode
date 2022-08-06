package com.nullzl.leetcode1100;

public class LeetCode1031 {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int max = Integer.MIN_VALUE;
        int fsum = 0;
        int ssum = 0;
        int len = firstLen + secondLen;
        int[] fmax = new int[nums.length];
        int[] smax = new int[nums.length];
        fmax[0] = nums[0];
        smax[0] = nums[0];
        fsum = nums[0];
        ssum = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            fsum += nums[i];
            ssum += nums[i];
            fsum -= i - firstLen >= 0 ? nums[i - firstLen] : 0;
            ssum -= i - secondLen >= 0 ? nums[i - secondLen] : 0;
            fmax[i] = Math.max(fmax[i-1],fsum);
            smax[i] = Math.max(smax[i-1],ssum);

            if(i - len  + 1 >= 0){
                max = Math.max(max,fsum + smax[i - firstLen]);
                max = Math.max(max,ssum + fmax[i - secondLen]);
            }
        }
        return max;
    }
}
