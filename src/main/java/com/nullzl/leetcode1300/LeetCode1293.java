package com.nullzl.leetcode1300;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1293 {
    int max = 0;
    int minStep = Integer.MAX_VALUE;

    private void visit1(boolean[][] visited,int[][] grid,int deleted,int i, int j,int step){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || step > minStep || visited[i][j])
            return ;
        deleted = (1 == grid[i][j]) ? deleted + 1 : deleted;
        if(deleted > max)
            return ;
        if(i == grid.length - 1 && j == grid[0].length - 1){
            minStep = step;
            return ;
        }

        visited[i][j] = true;
        step++;
        visit1(visited,grid,deleted,i - 1 ,j,step);
        visit1(visited,grid,deleted,i + 1 ,j,step);
        visit1(visited,grid,deleted,i ,j + 1,step);
        visit1(visited,grid,deleted,i ,j - 1,step);
        visited[i][j] = false;
    }


    public int shortestPath1(int[][] grid, int k) {
        boolean[][] visted = new boolean[grid.length][grid[0].length];
        int deleted = 0;
        max = k;
        visit1(visted,grid,0,0,0,0);
        return Integer.MAX_VALUE == minStep ? -1 : minStep;
    }

    private boolean visit(int[][] grid,boolean[][][] visited,List<int[]> next,int i,int j,int deleted,int k){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        if(1 == grid[i][j])
            deleted++;
        if(deleted > k || visited[i][j][deleted])
            return false;
        visited[i][j][deleted] = true;
        next.add(new int[]{i,j,deleted});
        if(i == grid.length - 1 && j == grid[0].length - 1)
            return true;
        return false;
    }
    public int shortestPath(int[][] grid, int k) {
        if(1 == grid.length && 1 == grid[0].length)
            return 0;
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        List<int[]> set = new ArrayList<>();
        List<int[]> next = new ArrayList<>();
        set.add(new int[]{0,0,0});
        int step = 0;
        while(!set.isEmpty()) {
            step++;
            for (int[] nums : set) {
                if (visit(grid, visited, next, nums[0] + 1, nums[1], nums[2], k)
                        || visit(grid, visited, next, nums[0] - 1, nums[1], nums[2], k)
                        || visit(grid, visited, next, nums[0], nums[1] + 1, nums[2], k)
                        || visit(grid, visited, next, nums[0], nums[1] - 1, nums[2], k))
                    return step;
            }
            List<int[]> temp = set;
            set = next;
            next = temp;
            next.clear();
        }
        return -1;
    }
}
