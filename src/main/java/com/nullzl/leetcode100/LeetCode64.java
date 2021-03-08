package com.nullzl.leetcode100;

public class LeetCode64 {

    public int minPathSum(int[][] grid) {
        if(null == grid || 0 == grid.length || null == grid[0] || 0 == grid[0].length){
            return 0 ;
        }
        int[][] minPath = new int[grid.length][grid[0].length];
        minPath[0][0] = grid[0][0];
        for(int i = 1 ; i < grid.length ; i++)
            minPath[i][0] = minPath[i-1][0] + grid[i][0];
        for(int i = 1 ; i < grid[0].length ; i++)
            minPath[0][i] = minPath[0][i-1] + grid[0][i];

        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length ; j++){
                minPath[i][j] = Math.min(minPath[i-1][j] + grid[i][j] , minPath[i][j-1] + grid[i][j]);
            }
        }
        return minPath[grid.length - 1][grid[0].length - 1];
    }
}
