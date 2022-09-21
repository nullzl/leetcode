package com.nullzl.leetcode900;

public class LeetCode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                row[i] = Math.max(row[i],grid[i][j]);
                col[j] = Math.max(col[j],grid[i][j]);
            }
        }
        int sum = 0;
        for(int i = 0 ;  i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                int h = Math.min(row[i],col[j]);
                sum += h - grid[i][j];
            }
        }
        return sum;
    }
}
