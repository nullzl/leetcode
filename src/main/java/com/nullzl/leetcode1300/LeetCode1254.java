package com.nullzl.leetcode1300;

public class LeetCode1254 {

    private void visit(int[][] grid,int i , int j ){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 1 == grid[i][j])
            return ;
        grid[i][j] = 1;
        visit(grid, i + 1, j);
        visit(grid, i - 1, j);
        visit(grid, i , j + 1);
        visit(grid, i , j - 1);
    }


    public int closedIsland(int[][] grid) {
        for(int i = 0 ; i < grid[0].length ; i++)
            visit(grid,0,i);
        for(int i = 1 ; i < grid.length - 1 ; i++){
            visit(grid,i,0);
            visit(grid,i,grid[i].length - 1);
        }
        for(int i = 0 ; i < grid[grid.length - 1].length ; i++)
            visit(grid,grid.length - 1,i);
        int count = 0;
        for(int i = 1 ; i < grid.length - 1 ; i++){
            for(int j = 1 ; j < grid[i].length - 1 ; j++){
                if(0 == grid[i][j]){
                    count++;
                    visit(grid,i,j);
                }
            }
        }
        return count;
    }
}
