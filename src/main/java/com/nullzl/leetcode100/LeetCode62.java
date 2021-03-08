package com.nullzl.leetcode100;

public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0)
            return 0 ;
        int[][] steps = new int[m][n];
        steps[0][0] = 0;
        for(int i = 1 ; i < n ; i++)
            steps[0][i] = 1;
        for(int i = 1; i < m ;i++)
            steps[i][0] = 1;
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++)
                steps[i][j] = steps[i-1][j] + steps[i][j-1];
        }
        return steps[m-1][n-1];
    }
}
