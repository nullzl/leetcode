package com.nullzl.leetcode1200;

import java.util.Arrays;

public class LeetCode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] count = new int[n + 2];
        for(int[] nums : bookings){
            count[nums[0]] += nums[2];
            count[nums[1] + 1] -= nums[2];
        }

        for(int i = 1 ; i <= n ; i++)
            count[i] += count[i - 1];
        return Arrays.copyOfRange(count,1,n + 1);
    }
}
