package com.nullzl.offer;

public class Offer2_41 {

    class MovingAverage {
        int count;
        int[] nums;
        int cur ;
        int sum = 0;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            count = 0;
            cur = -1;
            nums = new int[size];
        }

        public double next(int val) {
            cur = (cur + 1) % nums.length;
            count++;
            sum -= nums[cur];
            sum += val;
            nums[cur] = val;
            return (double)sum / (count >= nums.length ? nums.length : count);
        }
    }
}
