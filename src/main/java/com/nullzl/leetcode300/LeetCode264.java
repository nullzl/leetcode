package com.nullzl.leetcode300;

public class LeetCode264 {
    public int nthUglyNumber(int n) {

        if(1 == n)
            return 1;
        int[] nums = new int[1691];
        nums[1] = 1;
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int t1 , t2, t3;
        for(int i = 2 ;i <= n ; ){
            t1 = nums[p1] * 2;
            t2 = nums[p2] * 3;
            t3 = nums[p3] * 5;
            if(t1 <= t2 && t1 <= t3){
                if(t1 > nums[i-1]){
                    nums[i++] = t1;
                }
                p1++;
            }else if(t2 <= t1 && t2 <= t3){
                if(t2 > nums[i-1])
                    nums[i++] = t2;
                p2++;
            }else{
                if(t3 > nums[i-1])
                    nums[i++] = t3;
                p3++;
            }
        }
        return nums[n];
    }
}
