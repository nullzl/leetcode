package com.nullzl.leetcode1100;

public class LeetCode1011 {

    public int shipWithinDays(int[] weights, int D) {

        int sum = 0;
        int max = -1;
        for(int w : weights) {
            sum += w;
            max = Math.max(max,w);
        }

        int s = Math.max(max,sum / D + (0 == sum % D ? 0 : 1));
        int e = sum;

        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int tmp = 0;
            int days = 0;
            for(int w : weights){
                tmp += w;
                if(tmp > mid){
                    if(w > mid){
                        tmp = 0;
                        days = Integer.MAX_VALUE;
                    }else{
                        days++;
                        tmp = w;
                    }
                }
            }
            days += (0 == tmp ? 0 : 1);

            if(days <= D)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return s;
    }
}
