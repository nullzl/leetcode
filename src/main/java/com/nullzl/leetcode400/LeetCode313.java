package com.nullzl.leetcode400;

public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {

        if(1 == n)
            return 1;
        int[] nums = new int[n];
        nums[0] = 1;
        int[] p = new int[primes.length];
        for(int i = 1; i < n; ){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = 0 ; j < primes.length ; j++){
                if(-1 == p[j])
                    continue;
                long temp = (long)nums[p[j]] * primes[j];
                if(temp > Integer.MAX_VALUE){
                    p[j] = -1;
                    continue;
                }
                if(temp < min) {
                    min = (int) temp;
                    minIndex = j;
                }
            }
            p[minIndex]++;
            if(min != nums[i-1]){
                nums[i++] = min;
            }
        }
        return nums[n - 1];
    }
    public static void main(String[] args){

    }
}
