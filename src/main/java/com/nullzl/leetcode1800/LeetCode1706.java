package com.nullzl.leetcode1800;

public class LeetCode1706 {

    public int find(int[][] grid,int[][] balls,boolean[][] visited,int i , int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if(visited[i][j])
            return balls[i][j];
        if(1 == grid[i][j]){
            if(j + 1 == cols || -1 == grid[i][j+1])
                balls[i][j] = -1;
            else if(i + 1 == rows)
                balls[i][j] = j + 1;
            else
                balls[i][j] = find(grid,balls,visited,i + 1,j + 1);
        }else{
            if(j - 1 == -1 || 1 == grid[i][j-1])
                balls[i][j] = -1;
            else if(i + 1 == rows)
                balls[i][j] = j - 1;
            else
                balls[i][j] = find(grid,balls,visited,i + 1,j - 1);
        }
        visited[i][j] = true;
        return balls[i][j];

    }

    public int[] findBall(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] balls = new int[rows][cols];
        int[] rs = new int[cols];
        for(int i = 0 ; i < cols; i++){
            rs[i] = find(grid,balls,visited,0,i);
        }

        return rs;
    }
}
