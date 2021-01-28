package com.nullzl.LeetCode1400;

public class LeetCode1351 {

    public int countNegatives(int[][] grid) {

        int rows = grid.length - 1;
        int j = 0;
        int count = 0;
        for(int i = rows ; i >= 0 && j < grid[0].length; i--){
            while(j < grid[i].length && grid[i][j] >= 0) j++;
            count += (grid[i].length - j);
        }
        return count;
    }


}
