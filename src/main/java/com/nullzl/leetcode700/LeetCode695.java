package main.java.com.nullzl.leetcode700;

public class LeetCode695 {

    private int dfs(int[][] grid,int i ,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        if(1 != grid[i][j] )
            return 0;
        int count = 1;
        grid[i][j] = 2;
        count += dfs(grid,i+1,j);
        count += dfs(grid,i-1,j);
        count += dfs(grid,i,j-1);
        count += dfs(grid,i,j+1);
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(null == grid || 0 == grid.length
            || null == grid[0] || 0 == grid[0].length)
            return 0;
        int maxArea = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                int area = dfs(grid,i,j);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }
}
