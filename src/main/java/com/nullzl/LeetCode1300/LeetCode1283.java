package com.nullzl.LeetCode1300;

public class LeetCode1283 {

    public int smallestDivisor(int[] nums, int threshold) {

        int s = 1;
        int e = nums[0];
        for(int n : nums)
            e = Math.max(e,n);

        while(s <= e){
            int mid = s + ((e - s) >> 1);

            int sum = 0;
            for(int n : nums){
                sum += ((n + mid - 1) / mid);
            }

            if(sum <= threshold)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }
}
