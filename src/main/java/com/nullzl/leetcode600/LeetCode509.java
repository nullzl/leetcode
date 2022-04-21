package com.nullzl.leetcode600;

public class LeetCode509 {

    public int[][] multiple(int[][] a,int[][] b){
        int[][] ans = new int[a.length][a[0].length];
        for(int i = 0 ; i < a.length ; i++){
            for(int j= 0 ; j < a[i].length ; j++){
                for(int k = 0 ; k < a.length ; k++){
                    ans[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return ans;
    }

    public int fib(int n) {
        if(0 == n)
            return 0;
        if(1 == n)
            return 1;

        n -= 1;
        int[][] ans = new int[][]{{1,0},{0,1}};
        int[][] m = new int[][]{{0,1},{1,1}};
        while(0 != n){
            if(0 != (1 & n)){
                ans = multiple(ans,m);
            }
            n >>= 1;
            m = multiple(m,m);
        }
        return ans[1][1];
    }
}
