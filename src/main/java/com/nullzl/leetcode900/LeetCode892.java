package com.nullzl.leetcode900;

public class LeetCode892 {

    public int surfaceArea(int[][] grid) {

        if(null == grid || 0 == grid.length || null == grid[0])
            return 0;

        int area = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ;j < grid[i].length ; j++){
                if(0 == grid[i][j])
                    continue;
                area += (grid[i][j] * 4 + 2);
                if(i - 1 >= 0)
                    area -= (Math.min(grid[i][j],grid[i-1][j]));
                if(i + 1 < grid.length)
                    area -= (Math.min(grid[i][j],grid[i+1][j]));
                if(j - 1 >= 0)
                    area -= (Math.min(grid[i][j],grid[i][j-1]));
                if(j + 1 < grid[i].length)
                    area -= (Math.min(grid[i][j],grid[i][j+1]));
            }
        }
        return area;
    }
}
