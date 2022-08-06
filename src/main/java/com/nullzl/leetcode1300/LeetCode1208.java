package com.nullzl.leetcode1300;

public class LeetCode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int[] costs = new int [arr1.length];
        for(int i = 0 ;i < arr1.length; i++){
            costs[i] = Math.abs(arr1[i] - arr2[i]);
        }

        int sum = 0;
        int i = 0, j = 0;
        int max = 0;
        for(; j < costs.length ; j++){
            sum += costs[j];
            while(i <= j && sum > maxCost)
                sum -= costs[i++];
            max = Math.max(max,j - i + 1);
        }
        return max;
    }
}
