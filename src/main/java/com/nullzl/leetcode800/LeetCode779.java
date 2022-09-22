package com.nullzl.leetcode800;

public class LeetCode779 {

    public int kthGrammar(int n, int k) {
        if(1 == n && 1 == k)
            return 0;
        int[][] nums = new int[][]{{0,1},{1,0}};
        int num = 0;
        n--;k--;
        int x = 1 << (n - 1);
        while(0 != x){
            num = nums[num][k / x];
            k %= x;
            x >>= 1;
        }
        return num;
    }
}
